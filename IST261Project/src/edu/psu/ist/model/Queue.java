package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.psu.ist.model.Game;

public class Queue {


    private int size;

    private ArrayList<Game> gameList;

    private Game game1;
    private Game game2;
    private Game game3;



    public Queue(){
        this.size = 0;
        gameList = new ArrayList<Game>();
        createInitialElements();
        }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }

    public Game getGame1() {
        return game1;
    }

    public void setGame1(Game game1) {
        this.game1 = game1;
    }

    public Game getGame2() {
        return game2;
    }

    public void setGame2(Game game2) {
        this.game2 = game2;
    }

    public Game getGame3() {
        return game3;
    }

    public void setGame3(Game game3) {
        this.game3 = game3;
    }

    public Game getItem(){
        if(size == 0){
            System.out.println("Empty queue");
            return null;
        }
        return gameList.get(0);
    }

    public void addItem(Game toAdd){
        gameList.add(toAdd);
        size += 1;
    }

    public void updateItem(Game oldGame, Game newGame){
        if(size == 0){
            System.out.println("Empty Queue");
            return;
        }
        gameList.set(gameList.indexOf(oldGame), newGame);
//        index = 0;
//        while(index < size){
//            if(((Game)gameList.get(index)).getGameName().equals(oldGame.getGameName())){
//                gameList.set(index, newGame) = newGame;
//            }
//            index++;
//        }
    }

    public Game removeItem(){
        if(size == 0){
            System.out.println("Nothing in Queue");
            return null;
        }
        else {

            Game toReturn = getItem();
            gameList.remove(0);
            size -= 1;
            return toReturn;

        }
    }
    public void traverse(){
        for(Game game: this.gameList){
            System.out.println(game.getGameName());
        }
    }
    public void createInitialElements(){
        //Genre Creation
        ArrayList<String> genres1 = new ArrayList<String>(Arrays.asList("Survival", "Sandbox"));
        ArrayList<String> genres2 = new ArrayList<String>(Arrays.asList("RPG", "Fantasy"));
        ArrayList<String> genres3 = new ArrayList<String>(Arrays.asList("Survival", "Sandbox", "Farming"));

        //Rating Creation
        ArrayList<Double> rating1 = new ArrayList<>(Arrays.asList(97.0, 99.0));
        ArrayList<Double> rating2 = new ArrayList<>(Arrays.asList(90.0, 92.0));
        ArrayList<Double> rating3 = new ArrayList<>(Arrays.asList(95.0, 96.0));

        //Founder Creation
        Founder founder1 = new Founder("Markus Persson", 44);
        Founder founder2 = new Founder("Todd Howard", 57);
        Founder founder3 = new Founder("Eric Barone", 36);

        //GameCompany Creation
        GameCompany gameCompany1 = new GameCompany("Mojang", "SM", "Sweden", 2009, genres1);
        GameCompany gameCompany2 = new GameCompany("Bethesda", "MD", "US", 1998, genres2);
        GameCompany gameCompany3 = new GameCompany("ConcernedApe", "SM", "US", 2005, genres3);

        //Game Creation
        this.game1 = new Game("Minecraft", gameCompany1, "E", genres1, rating1, "Block based survival game", true);
        this.game2 = new Game("Skyrim", gameCompany2, "M", genres2, rating2, "Fantasy role playing game", false);
        this.game3 = new Game("Stardew Valley", gameCompany3, "E", genres3, rating3, "Fun farming simlulator with some fantasy elements", true);

        addItem(game1);
        addItem(game2);
        addItem(game3);
    }
}
