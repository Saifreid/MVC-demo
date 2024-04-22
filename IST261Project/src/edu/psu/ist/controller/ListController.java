package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.ListView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListController implements ActionListener {

    private ListView listView;

    List<Game> games = new ArrayList<>();

    GameTableModel gameTableModel;

    GameController gameController;

    GamePersistenceController gamePersistenceController;

    List<GameCompany> gameCompanies = new ArrayList<>();
    GameCompanyController gameCompanyController;
    GameCompanyPersistenceController gameCompanyPersistenceController;
    public ListController() {
        this.gamePersistenceController = new GamePersistenceController();
        games = gamePersistenceController.getGames();
        this.gameCompanyPersistenceController = new GameCompanyPersistenceController();
        gameCompanies = gameCompanyPersistenceController.getGameCompanies();
        this.gameTableModel = new GameTableModel(games);
        this.listView = new ListView(this);
        addActionListeners();
    }

    public GameTableModel getGameTableModel() {
        return this.gameTableModel;
    }

    public GameCompanyPersistenceController getGameCompanyPersistenceController(){
        return this.gameCompanyPersistenceController;
    }
    public List<Game> getGames() {
        return games;
    }
    public List<GameCompany> getGameCompanies(){
        return gameCompanies;
    }

    public GamePersistenceController getGamePersistenceController(){
        return this.gamePersistenceController;
    }


    public void addActionListeners() {
        listView.getNewButton().addActionListener(this);
        listView.getShowDetailsButton().addActionListener(this);
        listView.getDoneButton().addActionListener(this);
        listView.getGameCompaniesButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listView.getNewButton()) {
            //instantiate InstrumentController without the selectedRow

            this.gameController = new GameController(this);
            listView.dispose();

            //it may require new constructor in InstrumentController that accepts ListController as a parameter
            //make sure to clear the fields on the details view
        }

        if (e.getSource() == listView.getShowDetailsButton()) {
            int selectedRow = listView.getTblGame().getSelectedRow();
            if (selectedRow != -1) {
                listView.dispose();

                System.out.println("Selected Row = " + selectedRow);

                //if no row is selected on the list, set it to show first element on the details view
                //show a detail view with the data for the selected element
                //pass the flow from list controller to details controller
                //do not instantiate the details view from this list controller

                this.gameController = new GameController(this, selectedRow);

            } else {
                listView.dispose();
                this.gameController = new GameController(this, 0);
            }
        }

            if (e.getSource() == listView.getDoneButton()) {
                //implement functionality
                listView.dispose();
            }
            if (e.getSource() == listView.getGameCompaniesButton()){
                listView.dispose();
                this.gameCompanyController = new GameCompanyController(this, 0);
            }


        }


        public void showListView() {
            this.listView.setVisible(true);
        }

}

