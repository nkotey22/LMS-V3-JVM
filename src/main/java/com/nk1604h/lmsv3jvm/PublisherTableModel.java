package com.nk1604h.lmsv3jvm;

import coursework.controller.Controller;
import coursework.database.PUBLISHER;

import javax.swing.table.AbstractTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class PublisherTableModel extends AbstractTableModel implements PropertyChangeListener {

    public void setPublisherList(List<PUBLISHER> publisherList){
        this.publisherList = publisherList;
        fireTableChanged();
    }

    private List<PUBLISHER> publisherList;

    public PublisherTableModel(List<PUBLISHER> publisherList){
        this.publisherList = publisherList;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "NAME";
            default:
                return "ERROR";
        }
    }

    @Override
    public int getRowCount(){
        return publisherList.size();
    }

    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column){
        final PUBLISHER publisher = publisherList.get(row);
        switch (column){
            case 0:
                return publisher.getID();
            case 1:
                return publisher.getName();
            default:
                return "ERROR";
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        System.out.println(this + ":" + evt.toString());
        if (evt.getPropertyName() == "publisherList"){
            setPublisherList(List<PUBLISHER>) evt.getNewValue();
        }
    }
}