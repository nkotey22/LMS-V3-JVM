package com.nk1604h.lmsv3jvm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
public class MainPanel extends JPanel {
    private JTabbedPane appTabbedPane;

    public MainPanel(){
        super(new GridLayout(1,1));
        this.appTabbedPane = new JTabbedPane();

        // CREATE BOOKS AS A NEW TAB ON THE GUI
        appTabbedPane.addTab("BOOKS", new BookPanel());
        appTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        // CREATE AUTHORS AS A NEW TAB ON THE GUI
        appTabbedPane.addTab("AUTHORS", new AuthorPanel());
        appTabbedPane.setMnemonicAt(1, KeyEvent.VK_1);

        // CREATE PUBLISHERS AS A NEW TAB ON THE GUI
        appTabbedPane.addTab("PUBLISHERS", new PublisherPanel());
        appTabbedPane.setMnemonicAt(2, KeyEvent.VK_1);

        // CREATE SORTING AS A NEW TAB ON THE GUI
        appTabbedPane.addTab("SORTING", new SortPanel());
        appTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        add(appTabbedPane);
        appTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
}
