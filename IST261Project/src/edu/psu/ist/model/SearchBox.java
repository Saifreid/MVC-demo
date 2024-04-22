package edu.psu.ist.model;

import java.util.ArrayList;

public class SearchBox {
    private ArrayList<String> selectedGenres;
    private SortMenu sortMenu;
    private boolean showHideButton;

    public SearchBox(ArrayList<String> selectedGenres, SortMenu sortMenu, boolean showHideButton) {
        this.selectedGenres = selectedGenres;
        this.sortMenu = sortMenu;
        this.showHideButton = showHideButton;
    }

    public ArrayList<String> getSelectedGenres() {
        return selectedGenres;
    }

    public void setSelectedGenres(ArrayList<String> selectedGenres) {
        this.selectedGenres = selectedGenres;
    }

    public SortMenu getSortMenu() {
        return sortMenu;
    }

    public void setSortMenu(SortMenu sortMenu) {
        this.sortMenu = sortMenu;
    }

    public boolean isShowHideButton() {
        return showHideButton;
    }

    public void setShowHideButton(boolean showHideButton) {
        this.showHideButton = showHideButton;
    }

    @Override
    public String toString() {
        return "SearchBox{" +
                "selectedGenres=" + selectedGenres +
                ", sortMenu=" + sortMenu +
                ", showHideButton=" + showHideButton +
                '}';
    }
}
