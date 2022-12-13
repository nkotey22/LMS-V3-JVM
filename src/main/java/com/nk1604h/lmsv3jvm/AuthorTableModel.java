package com.nk1604h.lmsv3jvm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AuthorTableModel {

    public void setAuthorList(List<AUTHOR> authorList){
        this.authorList = authorList;
        fireTableDataChanged();
    }

    private List<AUTHOR> authorList;

    public AuthorTableModel(List<AUTHOR> authorList){
        this.authorList = authorList;

    }
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "FIRST NAME";
            case 1:
                return "SURNAME";
            default:
                return "ERROR";
        }
    }

    @Override
    public int getRowCount(){
        return authorList.size();
    }

    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column){
        final AUTHOR author = authorList.get(row);
        switch (column){
            case 0:
                return author.getFirstName();
            case 1:
                return author.getSurname();
            default:
                return "ERROR";
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        System.out.println(this + ":" + evt.toString());
        if (evt.getPropertyName() == "authorList"){
            setAuthorList((List<AUTHOR>) evt.getNewValue());
        }
    }
}
