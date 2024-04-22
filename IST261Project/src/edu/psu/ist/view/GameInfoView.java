package edu.psu.ist.view;

import edu.psu.ist.controller.GameController;
import edu.psu.ist.model.Game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInfoView extends JFrame {
    private JPanel pnlGameInfo;
    private JTextField ratingTextField;
    private JTextField gameNameTextField;
    private JTextField ageRatingTextField;
    private JTextField genresTextField;
    private JButton saveButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton deleteButton;
    private JButton createButton;
    private JLabel gameNameJLabel;
    private JLabel ageRatingJlabel;
    private JLabel genreJLabel;
    private JLabel ratingJLabel;
    private JButton goToListButton;

    private GameController gameController;

    private static final int FRAME_WIDTH = 500;

    private static final int FRAME_HEIGHT = 600;


    public GameInfoView(GameController gameController){
    this.gameController = gameController;
    createComponents();
    }

    public GameInfoView(GameController gameController, Game selectedGame){
        this.gameController = gameController;
        createComponents();
        displayGame(selectedGame);
    }


    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void createComponents(){
        this.add(pnlGameInfo);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Game GUI Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void displayGame(Game game){
        this.gameNameTextField.setText(game.getGameName());
        this.ageRatingTextField.setText(game.getAgeRating());
        this.genresTextField.setText(game.getGenresAsString());
        this.ratingTextField.setText(game.getAvgRating());
    }
    public void clearFields(){
        this.gameNameTextField.setText("");
        this.ageRatingTextField.setText("");
        this.genresTextField.setText("");
        this.ratingTextField.setText("");
    }

    public Game createGame() throws Exception {
        if(this.gameNameTextField.getText() == "" || this.ratingTextField.getText() == "" || this.genresTextField.getText() == "" || this.ageRatingTextField.getText() == ""){
            JOptionPane.showMessageDialog(this, "Please fill in all fields");

        }
        String gameName = this.gameNameTextField.getText();

        String ageRating = this.ageRatingTextField.getText();
        if(ageRating.equals("E") || ageRating.equals("M") || ageRating.equals("T")){

        }
        else{
            JOptionPane.showMessageDialog(this, "Age rating must be E, T, or M");

            throw(new Exception("Error ageRating needs to be E, T, or M"));
        }
        String genreList = this.genresTextField.getText();
        ArrayList<String> genres = new ArrayList<>();
        String[] genreSplit = genreList.split(", ");
        for(String genre: genreSplit){
            genres.add(genre);
        }

        String averageRatingString = this.ratingTextField.getText();
        try{
            if(gameName == "" || genres == null || ageRating == "" || averageRatingString == ""){
                JOptionPane.showMessageDialog(this, "Please fill in all fields");

            }
            Game gameTest = new Game(gameName, ageRating, genres, Double.parseDouble(averageRatingString));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Invalid rating must be number");

            System.out.println("Throwing exception: " + e);
        }
        return new Game(gameName, ageRating, genres, Double.parseDouble(averageRatingString));
    }

    public JButton getGoToListButton() {
        return goToListButton;
    }

    public void updateGame(List<Game> games, int index) throws Exception {
        if(this.gameNameTextField.getText() == "" || this.ratingTextField.getText() == "" || this.genresTextField.getText() == "" || this.ageRatingTextField.getText() == ""){
            JOptionPane.showMessageDialog(this, "Please fill in all fields");

        }
        games.get(index).setGameName(this.gameNameTextField.getText());

        String ageRating = this.ageRatingTextField.getText();

        if(ageRating.equals("E") || ageRating.equals("M") || ageRating.equals("T")){

        }
        else{
            JOptionPane.showMessageDialog(this, "Age rating must be either E, T, or M");

            throw(new Exception("Error ageRating needs to be E, T, or M"));
        }
        games.get(index).setAgeRating(ageRating);

        String genreList = this.genresTextField.getText();
        ArrayList<String> genres = new ArrayList<>();
        String[] genreSplit = genreList.split(", ");
        for(String genre: genreSplit){
            genres.add(genre);
        }
        games.get(index).setGenresForGame(genres);

        String averageRatingString = this.ratingTextField.getText();
        try{
            games.get(index).setRatings(new ArrayList<>(Arrays.asList(Double.parseDouble(averageRatingString))));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Invalid rating");

            System.out.println("Throwing exception: " + e);
        }

    }

}
