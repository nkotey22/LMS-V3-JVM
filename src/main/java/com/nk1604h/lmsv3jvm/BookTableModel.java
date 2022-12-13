package com.nk1604h.lmsv3jvm;

//import coursework.database.BOOKS;
import javax.swing.table.AbstractTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;

public class BookTableModel extends AbstractTableModel implements PropertyChangeListener {

    public void setBookList(List<BOOK> bookList){
        this.bookList = bookList;
        fireTableDataChanged();
    }

    private List<BOOK> bookList;

    private BookTableModel(List<BOOK> bookList){this.bookList = bookList;}

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "TITLE";
            case 1:
                return "AUTHOR(S)";
            case 2:
                return "YEAR OF PUBLICATION";
            case 3:
                return "PUBLISHER";
            case 4:
                return "SUBJECT";
            default:
                return "ERROR";
        }
    }

    @Override
    public int getRowCount() {return bookList.size();}

    @Override
    public int getColumnCount(){return 5;}

    @Override
    public Object getValueAt(int row, int column){
        final BOOK book = bookList.get(row);
        switch (column) {
            case 0:
                return book.getTitle();
            case 1:
                return book.getAuthor();
            case 2:
                return book.getYearOfPub();
            case 3:
                return book.getPublisher();
            case 4:
                return book.getSubject();
            default:
                return "ERROR";
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(this + ":" + evt.toString());
        if (evt.getPropertyName() == "bookList"){
            setBookList((List<BOOK>) evt.getNewValue());
        }
    }
}