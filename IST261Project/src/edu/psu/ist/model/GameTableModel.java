package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class GameTableModel extends AbstractTableModel {

    //come back to this
    private String[] columnNames = {"Game", "Company", "Genres"};

    private List<Game> gameList;

    public GameTableModel(List<Game> gameList){
        this.gameList = gameList;
    }


    @Override
    public int getRowCount() {
        return gameList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return (Object) gameList.get(rowIndex).getGameName();
            case 1: return (Object) gameList.get(rowIndex).getGameCompany().getName();
            case 2: return (Object) gameList.get(rowIndex).getGenresForGame();

        }

        return null;
    }
}
