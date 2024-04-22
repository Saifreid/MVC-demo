package edu.psu.ist.controller;

import edu.psu.ist.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class GameCompanyPersistenceController {

    private List<GameCompany> gameCompanies = new ArrayList<>();

    private String fileName = "GameCompanyFile.txt";

    public GameCompanyPersistenceController(){
        readGameCompanyFile();
        if(gameCompanies.isEmpty()){
            createInitialElements();
            writeGameCompanyFile();
        }

    }

    public List<GameCompany> getGameCompanies() {
        return gameCompanies;
    }

    public void writeGameCompanyFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(gameCompanies);
            out.close();
            System.out.println("Successful in writing to file");

        }catch(IOException e){
            System.out.println("Caught exception while writing to file");
        }
    }

    public void readGameCompanyFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            gameCompanies = (ArrayList) in.readObject();
            in.close();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Caught exception while reading from file: " + e.getMessage());
        }
        System.out.println("Successful in Reading from file");
    }
    private void createInitialElements(){
        //GameCompany Creation
        GameCompany gameCompany1 = new GameCompany("Mojang", "SM", "Sweden", 2009);
        GameCompany gameCompany2 = new GameCompany("Bethesda", "MD", "US", 1998);
        GameCompany gameCompany3 = new GameCompany("ConcernedApe", "SM", "US", 2005);

        gameCompanies.add(gameCompany1);
        gameCompanies.add(gameCompany2);
        gameCompanies.add(gameCompany3);
    }
}
