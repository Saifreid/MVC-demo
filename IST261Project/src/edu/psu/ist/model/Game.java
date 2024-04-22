package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

public class Game implements SearchInformation, Serializable {
    private String gameName;
    private GameCompany gameCompany;
    private String ageRating;
    private ArrayList<String> genresForGame;
    private ArrayList<Double> ratings;
    private String description;
    private boolean multiplayer;

    public Game(String gameName, GameCompany gameCompany, String ageRating, ArrayList<String> genresForGame, ArrayList<Double> ratings, String description, boolean multiplayer) {
        this.gameName = gameName;
        this.gameCompany = gameCompany;
        this.ageRating = ageRating;
        this.genresForGame = genresForGame;
        this.ratings = ratings;
        this.description = description;
        this.multiplayer = multiplayer;
    }
    public Game(String gameName, String ageRating, ArrayList<String> genresForGame, Double averageRating){
        this.gameName = gameName;
        this.ratings = new ArrayList<Double>(Arrays.asList(averageRating));
        this.ageRating = ageRating;
        this.genresForGame = genresForGame;
        this.gameCompany = new GameCompany();
    }


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public GameCompany getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(GameCompany gameCompany) {
        this.gameCompany = gameCompany;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public ArrayList<String> getGenresForGame() {
        return genresForGame;
    }

    public void setGenresForGame(ArrayList<String> genresForGame) {
        this.genresForGame = genresForGame;
    }

    public String getGenresAsString(){
        String toReturn = "";
        for(String genre: this.genresForGame){
            if(toReturn.equals("")){

            }
            else{
                toReturn += ", ";
            }
            toReturn += genre;
        }
        return toReturn;
    }
    public ArrayList<Double> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Double> ratings) {
        this.ratings = ratings;
    }

    public String getAvgRating(){
        double averageRating = 0;
        for(int i = 0; i < ratings.size(); i++){
            averageRating += ratings.get(i);
        }
        averageRating = averageRating/ratings.size();
        return averageRating + "";
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }
    public String isThisMultiplayer(){
        return "Multiplayer for " + gameName + ": " + multiplayer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", gameCompany=" + gameCompany.getName() +
                ", ageRating='" + ageRating + '\'' +
                ", genresForGame=" + genresForGame +
                ", ratings=" + ratings +
                ", description='" + description + '\'' + " Multiplayer = " + multiplayer +
                '}';
    }

    @Override
    public String getInformationType() {
        return "This is \"Game\"";
    }

    @Override
    public boolean getIsSearchable() {
        return true;
    }
}