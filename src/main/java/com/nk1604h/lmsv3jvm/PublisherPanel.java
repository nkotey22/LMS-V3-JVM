package com.nk1604h.lmsv3jvm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
public class PublisherPanel extends JPanel {
    public PublisherPanel(){
        setLayout(new GridLayout(1,2));
        add(new PublisherPanel.PublisherFormPanel());
        final AuthorTableModel AuthorTableModel = new AuthorTableModel(Controller.INSTANCE.getAuthorList());
        Controller.INSTANCE.addPropertyChangeListener(AuthorTableModel);
        add(new JScrollPane(new JTable(PublisherTableModel)));
    }

    public static class BookFormPanel extends JPanel{
        private final JTextField nameTextField;

        private final JButton addButton;

        public publisherFormPanel(){
            nameTextField = new JTextField();
            addButton = new JButton("ADD");

            CreateUILayout();
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameTextField.getText();
                    Controller.INSTANCE.add_publisher(name);
                }
            });

            private void createUILayout(){
                setLayout(new GridBagLayout());
                setBorder(BorderFactory.createTitledBorder("Publisher"));
                GridBagConstraints gc = new GridBagConstraints();
                gc.weightx = 1;
                gc.weighty = 1;
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.insets = new Insets(0,4,0,5);
                gc.anchor = GridBagConstraints.LINE_END;

                gc.gridx = 0;
                gc.gridy = 0;
                add(new JLabel("Name: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 0;
                add(nameTextField, gc);

            }

        }
    }
}
