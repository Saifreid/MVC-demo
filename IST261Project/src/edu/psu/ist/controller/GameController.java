package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.GameInfoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameController implements ActionListener {

    private GameInfoView gameInfoView;

    private List<Game> games = new ArrayList<>();

    private ListController listController;
    int currentIndex;

    public GameController(ListController listController, int selectedRow){
        this.listController = listController;
        this.games = listController.getGames();
        Game selectedGame = games.get(selectedRow);
        this.gameInfoView = new GameInfoView(this, selectedGame);
        this.currentIndex = selectedRow;
        addActionListeners();

    }
    public GameController(ListController listController){
        this.listController = listController;
        this.games = listController.getGames();
        this.games.add(new Game("", "", new ArrayList<String>(List.of("")),0.0));
        Game selectedGame = games.get(games.size()-1);
        this.gameInfoView = new GameInfoView(this, selectedGame);
        this.currentIndex = games.size()-1;
        addActionListeners();
    }
    public void displayGame(int index){
        Game currentGame = games.get(index);
        gameInfoView.displayGame(currentGame);
    }



    private void addActionListeners() {
        gameInfoView.getCreateButton().addActionListener(this);
        gameInfoView.getDeleteButton().addActionListener(this);
        gameInfoView.getNextButton().addActionListener(this);
        gameInfoView.getPrevButton().addActionListener(this);
        gameInfoView.getSaveButton().addActionListener(this);
        gameInfoView.getGoToListButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton actionSource = (JButton)e.getSource();
        //This is for Create Button
        if(actionSource == gameInfoView.getCreateButton()){
            try {
                games.add(gameInfoView.createGame());
                gameInfoView.clearFields();
                currentIndex = 0;
                displayGame(currentIndex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gameInfoView, "Failed to create");

                throw new RuntimeException(ex);
            }
        }
        //This is for Delete Button
        if(actionSource == gameInfoView.getDeleteButton()){
            games.remove(currentIndex);
            currentIndex = 0;
            gameInfoView.clearFields();
            displayGame(currentIndex);
            listController.getGamePersistenceController().writeGameFile();
        }
        //This is for Next Button
        if(actionSource == gameInfoView.getNextButton()){
            currentIndex += 1;
            if(currentIndex == games.size()){
                currentIndex = 0;
            }
            gameInfoView.clearFields();
            displayGame(currentIndex);
        }
        //This is for Prev Button
        if(actionSource == gameInfoView.getPrevButton()){
            currentIndex -= 1;
            if(currentIndex < 0){
                currentIndex = games.size() -1;
            }

            gameInfoView.clearFields();
            displayGame(currentIndex);
        }
        //This is for Save Button
        if(actionSource == gameInfoView.getSaveButton()){
            try {
                gameInfoView.updateGame(games,currentIndex);
                listController.getGamePersistenceController().writeGameFile();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gameInfoView, "Error cannot save");

                throw new RuntimeException(ex);
            }
        }
        if(actionSource == gameInfoView.getGoToListButton()){
            this.gameInfoView.dispose();
            listController.showListView();
        }

    }
}
