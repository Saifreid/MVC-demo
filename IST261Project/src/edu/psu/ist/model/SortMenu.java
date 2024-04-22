package edu.psu.ist.model;

import java.util.ArrayList;

public class SortMenu {
    private String sortType;
    private ArrayList<String> categoricalFilter;

    public SortMenu(String sortType, ArrayList<String> categoricalFilter) {
        this.sortType = sortType;
        this.categoricalFilter = categoricalFilter;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public ArrayList<String> getCategoricalFilter() {
        return categoricalFilter;
    }

    public void setCategoricalFilter(ArrayList<String> categoricalFilter) {
        this.categoricalFilter = categoricalFilter;
    }

    @Override
    public String toString() {
        return "SortMenu{" +
                "sortType='" + sortType + '\'' +
                ", categoricalFilter=" + categoricalFilter +
                '}';
    }
}
