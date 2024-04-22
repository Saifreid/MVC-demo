package edu.psu.ist.model;

import java.util.ArrayList;

public class MultiplayerGame extends Game implements PlayerGame{
    private Integer playerCount;
    public MultiplayerGame(String gameName, GameCompany gameCompany, String ageRating, ArrayList<String> genresForGame, ArrayList<Double> ratings, String description, Integer players) {
        super(gameName, gameCompany, ageRating, genresForGame, ratings, description, true);
        this.playerCount = players;

    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    @Override
    public String isThisMultiplayer(){
        return "" + super.getGameName() + " is multiplayer";
    }

    @Override
    public String playerCountString(){
        return "This game can have " + this.playerCount + " players";
    }

    @Override
    public String toString(){
        return super.toString() + " Players = " + playerCount;
    }
}
