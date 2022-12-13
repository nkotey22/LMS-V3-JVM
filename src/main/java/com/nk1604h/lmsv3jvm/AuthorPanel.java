package com.nk1604h.lmsv3jvm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
public class AuthorPanel extends JPanel {

    public AuthorPanel(){
        setLayout(new GridLayout(1,2));
        add(new AuthorPanel.AuthorFormPanel());
        final AuthorTableModel AuthorTableModel = new AuthorTableModel(Controller.INSTANCE.getAuthorList());
        Controller.INSTANCE.addPropertyChangeListener(AuthorTableModel);
        add(new JScrollPane(new JTable(AuthorTableModel)));
    }

    public static class BookFormPanel extends JPanel{
        private final JTextField firstNameTextField;

        private final JTextField surnameTextField;

        private final JButton addButton;

        public authorFormPanel(){
            firstNameTextField = new JTextField();
            surnameTextField = new JTextField();
            addButton = new JButton("ADD");

            CreateUILayout();
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String firstName = firstNameTextField.getText();
                    String surname = surnameTextField.getText();
                    Controller.INSTANCE.add_author(firstName, surname);
                }
            });

            private void createUILayout(){
                setLayout(new GridBagLayout());
                setBorder(BorderFactory.createTitledBorder("Author"));
                GridBagConstraints gc = new GridBagConstraints();
                gc.weightx = 1;
                gc.weighty = 1;
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.insets = new Insets(0,4,0,5);
                gc.anchor = GridBagConstraints.LINE_END;

                gc.gridx = 0;
                gc.gridy = 0;
                add(new JLabel("First Name: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 0;
                add(firstNameTextField, gc);

                gc.gridx = 0;
                gc.gridy = 1;
                add(new JLabel("Surname: ", SwingConstants.RIGHT),gc);

                gc.gridx = 1;
                gc.gridy = 1;
                add(surnameTextField, gc);

            }

        }
    }
}
