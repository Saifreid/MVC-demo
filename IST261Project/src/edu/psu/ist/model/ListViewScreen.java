package edu.psu.ist.model;

import java.util.ArrayList;

public class ListViewScreen {
    private ArrayList<Game> viewScreenGameList;
    private SortMenu viewSortMenu;

    public ListViewScreen(ArrayList<Game> viewScreenGameList, SortMenu viewSortMenu) {
        this.viewScreenGameList = viewScreenGameList;
        this.viewSortMenu = viewSortMenu;
    }

    public ArrayList<Game> getViewScreenGameList() {
        return viewScreenGameList;
    }

    public void setViewScreenGameList(ArrayList<Game> viewScreenGameList) {
        this.viewScreenGameList = viewScreenGameList;
    }

    public SortMenu getViewSortMenu() {
        return viewSortMenu;
    }

    public void setViewSortMenu(SortMenu viewSortMenu) {
        this.viewSortMenu = viewSortMenu;
    }

    @Override
    public String toString() {
        return "ListViewScreen{" +
                "viewScreenGameList=" + viewScreenGameList +
                ", viewSortMenu=" + viewSortMenu +
                '}';
    }
}
