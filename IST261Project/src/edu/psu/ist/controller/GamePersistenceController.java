package edu.psu.ist.controller;

import edu.psu.ist.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GamePersistenceController {

    private List<Game> games = new ArrayList<>();

    private String fileName = "GameFile.txt";

    public GamePersistenceController(){
        readGameFile();
        if(games.isEmpty()){
            createInitialElements();
            writeGameFile();
        }
    }

    public List<Game> getGames(){
        return games;
    }

    public void writeGameFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(games);
            out.close();
            System.out.println("Successful in writing to file");

        } catch(IOException e){
            System.out.println("Caught exception while writing to file");
        }
    }

    public void readGameFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            games = (ArrayList) in.readObject();
            in.close();
            //System.out.println("Successful in Reading from file");
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Caught exception while reading from file: " + e.getMessage());
        }
        System.out.println("Successful in Reading from file");
    }

    private void createInitialElements() {
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
        Game game1 = new Game("Minecraft", gameCompany1, "E", genres1, rating1, "Block based survival game", true);
        Game game2 = new Game("Skyrim", gameCompany2, "M", genres2, rating2, "Fantasy role playing game", false);
        Game game3 = new Game("Stardew Valley", gameCompany3, "E", genres3, rating3, "Fun farming simlulator with some fantasy elements", true);

        //Adding games to the games list
        games.add(game1);
        games.add(game2);
        games.add(game3);

    }

}
