package com.nk1604h.lmsv3jvm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


public class BookPanel extends JPanel {
    //TABLE OUTPUT

    public BookPanel(){
        setLayout(new GridLayout(1,2));
        add(new BookFormPanel());
        final BookTableModel BookTableModel = new BookTableModel(Controller.INSTANCE.getBookList());
        Controller.INSTANCE.addPropertyChangeListener(BookTableModel);
        add(new JScrollPane(new JTable(BookTableModel)));
    }

    public static class BookFormPanel extends JPanel{
        private final JTextField titleTextField;

        private final JTextField authorTextField;

        private final JTextField yearOfPubTextField;

        private final JTextField publisherTextField;

        private final JTextField subjectTextField;

        private final JButton addButton;

        //jcombobox nt yet becessarry

        public BookFormPanel(){
            titleTextField = new JTextField();
            authorTextField = new JTextField();
            yearOfPubTextField = new JTextField();
            publisherTextField = new JTextField();
            subjectTextField = new JTextField();
            addButton = new JButton("ADD");

            CreateUILayout();

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String title = titleTextField.getText();
                    String author = authorTextField.getText();
                    String yearOfPub = yearOfPubTextField.getText();
                    String publisher = publisherTextField.getText();
                    String subject = subjectTextField.getText();
                    Controller.INSTANCE.add_book(title,author, yearOfPub, publisher, subject);
                }
            });

            private void createUILayout(){
                setLayout(new GridBagLayout());
                setBorder(BorderFactory.createTitledBorder("Book"));
                GridBagConstraints gc = new GridBagConstraints();
                gc.weightx = 1;
                gc.weighty = 1;
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.insets = new Insets(0,4,0,5);
                gc.anchor = GridBagConstraints.LINE_END;

                gc.gridx = 0;
                gc.gridy = 0;
                add(new JLabel("Title: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 0;
                add(titleTextField, gc);

                gc.gridx = 0;
                gc.gridy = 1;
                add(new JLabel("Author(s): ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 1;
                add(authorTextField, gc);

                gc.gridx = 0;
                gc.gridy = 2;
                add(new JLabel("Year of Publication: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 2;
                add(yearOfPubTextField, gc);

                gc.gridx = 0;
                gc.gridy = 3;
                add(new JLabel("Publisher: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 3;
                add(publisherTextField, gc);

                gc.gridx = 0;
                gc.gridy = 4;
                add(new JLabel("Subject: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 4;
                add(subjectTextField,gc);

                gc.gridx = 1;
                gc.gridy = 5;
                add(subjectTextField);

            }
        }

    }
}
