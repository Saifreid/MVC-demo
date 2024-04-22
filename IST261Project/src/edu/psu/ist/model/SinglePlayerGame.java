package edu.psu.ist.model;

import java.util.ArrayList;

public class SinglePlayerGame extends  Game implements PlayerGame {

    public SinglePlayerGame(String gameName, GameCompany gameCompany, String ageRating, ArrayList<String> genresForGame, ArrayList<Double> ratings, String description) {
        super(gameName, gameCompany, ageRating, genresForGame, ratings, description, false);
    }
    public Integer getPlayers(){
        return 1;
    }
    @Override
    public String isThisMultiplayer(){
        return "" + super.getGameName() + " is not multiplayer";
    }
    @Override
    public String playerCountString(){
        return "This game can have 1 player";
    }

    @Override
    public String toString() {
        return (super.toString() + "- SinglePlayer");
    }
}
