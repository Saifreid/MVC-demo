package edu.psu.ist.test;

import edu.psu.ist.model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Founder founder1 = new Founder("Todd Howard",56);
    Founder founder2 = new Founder("Todd Howardest",60);

    ArrayList<Founder> foundersList1 = new ArrayList<>(Arrays.asList(founder1));
    ArrayList<Founder> foundersList2 = new ArrayList<>(Arrays.asList(founder1, founder2));

    ArrayList<String> genres1 = new ArrayList<>(Arrays.asList("RPG", "Fantasy"));
    ArrayList<String> genres2 = new ArrayList<>(Arrays.asList("RPG", "Fantasy", "Dark"));

    GameCompany gameCompany1 = new GameCompany("Bethesda", "MED", "CA", 1996, foundersList1, genres1);
    GameCompany gameCompany2 = new GameCompany("Riot", "LG", "CA", 2001, foundersList2, genres2);

    ArrayList<GameCompany> gameCompanyList1 = new ArrayList<>(Arrays.asList(gameCompany1));
    ArrayList<GameCompany> gameCompanyList2 = new ArrayList<>(Arrays.asList(gameCompany1, gameCompany2));
    ArrayList<Double> game1Ratings = new ArrayList<>(Arrays.asList(99.0, 95.0));
    ArrayList<Double> game2Ratings = new ArrayList<>(Arrays.asList(92.0, 98.0));
    Game game1 = new Game("Mario",gameCompany1, "E", genres1, game1Ratings,"A simple platformer for kids", true);
    Game game2 = new Game("Pokemon",gameCompany2, "E", genres2, game2Ratings,"A simple monster game for kids", true);
    @Test
    void gameToString(){
        assertEquals("Game{" +
                "gameName='" + "Mario" + '\'' +
                ", gameCompany=" + "Bethesda" +
                ", ageRating='" + "E" + '\'' +
                ", genresForGame=" + "[RPG, Fantasy]" +
                ", ratings=" + "[99.0, 95.0]" +
                ", description='" + "A simple platformer for kids" + '\'' +
                '}', game1.toString());
    }
    @Test
    void getGameName(){
        assertEquals("Mario", game1.getGameName());
    }
    @Test
    void getGameCompany(){
        assertEquals(gameCompany1, game1.getGameCompany());
    }
    @Test
    void getGameAgeRating(){
        assertEquals("E", game1.getAgeRating());
    }
    @Test
    void getGameGenres(){
        assertEquals(genres1, game1.getGenresForGame());
    }
    @Test
    void getGameRatings(){
        assertEquals(game1Ratings, game1.getRatings());
    }
    @Test
    void getGameDesc(){
        assertEquals("A simple platformer for kids", game1.getDescription());
    }
    @Test
    void setGameName(){
        game1.setGameName("Pokemon");
        assertEquals("Pokemon", game1.getGameName());
    }
    @Test
    void setGameCompany(){
        game1.setGameCompany(gameCompany2);
        assertEquals(gameCompany2, game1.getGameCompany());
    }
    @Test
    void setAgeRating(){
        game1.setAgeRating("M");
        assertEquals("M", game1.getAgeRating());
    }
    @Test
    void setGenres(){
        game1.setGenresForGame(genres2);
        assertEquals(genres2, game1.getGenresForGame());
    }
    @Test
    void setRatings(){
        game1.setRatings(game2Ratings);
        assertEquals(game2Ratings, game1.getRatings());
    }
    @Test
    void setDescription(){
        game1.setDescription("A fun monster tamer game");
        assertEquals("A fun monster tamer game", game1.getDescription());
    }

}
