package edu.psu.ist.view;

import javax.swing.*;
import edu.psu.ist.controller.GameCompanyController;
import edu.psu.ist.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameCompanyView extends JFrame {
    private JPanel panel1;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton createButton;
    private JButton prevButton;
    private JButton goToListButton;
    private JButton nextButton;
    private JTextField companyNameText;
    private JTextField establishedText;
    private JTextField locationText;
    private JTextField sizeText;
    private JLabel nameJLabel;
    private JLabel locationJLabel;
    private JLabel sizeJLabel;
    private JLabel establishedJLabel;

    private GameCompanyController gameCompanyController;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;


    public GameCompanyView(GameCompanyController gameCompanyController, GameCompany selectedGameCompany){
        this.gameCompanyController = gameCompanyController;
        createComponents();
        displayGameCompany(selectedGameCompany);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getGoToListButton() {
        return goToListButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JTextField getCompanyNameText() {
        return companyNameText;
    }

    public void setCompanyNameText(JTextField companyNameText) {
        this.companyNameText = companyNameText;
    }

    public JTextField getEstablishedText() {
        return establishedText;
    }

    public void setEstablishedText(JTextField establishedText) {
        this.establishedText = establishedText;
    }

    public JTextField getLocationText() {
        return locationText;
    }

    public void setLocationText(JTextField locationText) {
        this.locationText = locationText;
    }

    public JTextField getSizeText() {
        return sizeText;
    }

    public void setSizeText(JTextField sizeText) {
        this.sizeText = sizeText;
    }

    public void createComponents(){
        this.add(panel1);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Game Companies");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public GameCompany createGameCompany(){
        String gameCompanyName = companyNameText.getText().trim();
        String gameCompanyLocation = locationText.getText().trim();
        String gameCompanySize = sizeText.getText().trim();
        Integer establishedYear = 0;
        try{
            establishedYear = Integer.parseInt(establishedText.getText().trim());
        }catch(NumberFormatException e){
            return null;
        }
        GameCompany gameCompany = new GameCompany(gameCompanyName, gameCompanySize, gameCompanyLocation, establishedYear, new ArrayList<>());
        return gameCompany;
    }
    public void displayGameCompany(GameCompany gameCompany){
        this.companyNameText.setText(gameCompany.getName());
        this.establishedText.setText(String.valueOf(gameCompany.getEstablished()));
        this.sizeText.setText(gameCompany.getSize());
        this.locationText.setText(gameCompany.getLocation());
    }
    public void updateGameCompany(List<GameCompany> gameCompanies, int index){
        gameCompanies.get(index).setName(this.companyNameText.getText().trim());
        int established = Integer.parseInt(this.establishedText.getText().trim());
        gameCompanies.get(index).setEstablished(established);
        gameCompanies.get(index).setSize(this.sizeText.getText().trim());
        gameCompanies.get(index).setLocation(this.locationText.getText().trim());
    }
    public void clearFields(){

        this.companyNameText.setText("");
        this.establishedText.setText("");
        this.sizeText.setText("");
        this.locationText.setText("");
    }
}
