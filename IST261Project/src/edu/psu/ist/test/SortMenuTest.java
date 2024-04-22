package edu.psu.ist.test;

import edu.psu.ist.model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortMenuTest {
    ArrayList<String> genres1 = new ArrayList<>(List.of("Fantasy", "RPG"));
    SortMenu sortMenu1 = new SortMenu("Rating", genres1);



    @Test
    void getSortType(){
        assertEquals("Rating", sortMenu1.getSortType());
    }
    @Test
    void getCategoricalFilter(){
        assertEquals(genres1, sortMenu1.getCategoricalFilter());
    }
    @Test
    void sortMenuToString(){
        assertEquals("SortMenu{" +
                "sortType='" + "Rating" + '\'' +
                ", categoricalFilter=" +  "[Fantasy, RPG]"+
                '}',sortMenu1.toString());
    }

    @Test
    void setSortType(){
        sortMenu1.setSortType("Recent");
        assertEquals("Recent", sortMenu1.getSortType());
    }
    @Test
    void setCategoricalFilter(){
        sortMenu1.setCategoricalFilter(new ArrayList<>(List.of("Fantasy")));
        assertEquals(new ArrayList<>(List.of("Fantasy")), sortMenu1.getCategoricalFilter());
    }

}
