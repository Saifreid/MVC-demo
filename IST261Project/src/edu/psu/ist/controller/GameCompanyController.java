package edu.psu.ist.controller;

import edu.psu.ist.model.GameCompany;
import edu.psu.ist.view.GameCompanyView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class GameCompanyController implements ActionListener{
    private GameCompanyView gameCompanyView;
    private List<GameCompany> gameCompanies = new ArrayList<>();
    int currentIndex;

    ListController listController;

    public GameCompanyController(ListController listController, int selectedRow){
        this.listController = listController;
        this.gameCompanies = listController.getGameCompanies();
        GameCompany selectedGameCompany = gameCompanies.get(selectedRow);
        this.gameCompanyView = new GameCompanyView(this, selectedGameCompany);
        this.listController = listController;
        this.currentIndex = 0;
        addActionListeners();

    }

    public void addActionListeners(){
        gameCompanyView.getCreateButton().addActionListener(this);
        gameCompanyView.getDeleteButton().addActionListener(this);
        gameCompanyView.getGoToListButton().addActionListener(this);
        gameCompanyView.getNextButton().addActionListener(this);
        gameCompanyView.getPrevButton().addActionListener(this);
        gameCompanyView.getSaveButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton actionSource = (JButton) e.getSource();
        if(actionSource == gameCompanyView.getCreateButton()){
            try{
                gameCompanies.add(gameCompanyView.createGameCompany());
                gameCompanyView.clearFields();
                currentIndex = 0;
                displayGameCompany(currentIndex);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(gameCompanyView, "Failed to create");
                throw new RuntimeException();
            }
        }
        if(actionSource == gameCompanyView.getDeleteButton()){

            gameCompanies.remove(currentIndex);
            currentIndex = 0;
            gameCompanyView.clearFields();
            displayGameCompany(currentIndex);
            //SET PERSISTENCE HERE
        }
        if(actionSource == gameCompanyView.getNextButton()){
            currentIndex += 1;
            if(currentIndex == gameCompanies.size()){
                currentIndex = 0;
            }
            gameCompanyView.clearFields();
            displayGameCompany(currentIndex);
        }
        if(actionSource == gameCompanyView.getPrevButton()){
            currentIndex -= 1;
            if (currentIndex < 0){
                currentIndex = gameCompanies.size() - 1;
            }
            gameCompanyView.clearFields();
            displayGameCompany(currentIndex);
        }

        if(actionSource == gameCompanyView.getGoToListButton()){
            this.gameCompanyView.dispose();
            listController.showListView();
        }

        if(actionSource == gameCompanyView.getSaveButton()){
            try{
                gameCompanyView.updateGameCompany(gameCompanies, currentIndex);
                listController.getGameCompanyPersistenceController().writeGameCompanyFile();
            }   catch(Exception ex){
                JOptionPane.showMessageDialog(gameCompanyView, "Error cannot save");
                throw new RuntimeException(ex);
            }
        }

    }

    public void displayGameCompany(int index){
        GameCompany previousGameCompany = gameCompanies.get(index);
        gameCompanyView.displayGameCompany(previousGameCompany);
    }


}
