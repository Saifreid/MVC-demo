package edu.psu.ist.view;

import edu.psu.ist.controller.ListController;

import javax.swing.*;

public class ListView extends JFrame{
    private JPanel pnlRoot;
    private JPanel pnlButtons;
    private JButton newButton;
    private JButton showDetailsButton;
    private JButton doneButton;
    private JPanel pnlTable;
    private JTable tblGame;
    private JScrollPane scrollPane;
    private JButton gameCompaniesButton;

    private static final int FRAME_WIDTH = 500;

    private static final int FRAME_HEIGHT = 600;

    private ListController listController;

    public ListView(ListController listController){
        this.listController = listController;
        createListComponents();
    }

    private void createListComponents() {
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setTitle("Game List Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        tblGame.setModel(listController.getGameTableModel());

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
    public JButton getGameCompaniesButton(){
        return gameCompaniesButton;
    }

    public JPanel getPnlRoot() {
        return pnlRoot;
    }

    public void setPnlRoot(JPanel pnlRoot) {
        this.pnlRoot = pnlRoot;
    }

    public JPanel getPnlButtons() {
        return pnlButtons;
    }

    public void setPnlButtons(JPanel pnlButtons) {
        this.pnlButtons = pnlButtons;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public void setNewButton(JButton newButton) {
        this.newButton = newButton;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(JButton showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public void setDoneButton(JButton doneButton) {
        this.doneButton = doneButton;
    }

    public JPanel getPnlTable() {
        return pnlTable;
    }

    public void setPnlTable(JPanel pnlTable) {
        this.pnlTable = pnlTable;
    }

    public JTable getTblGame() {
        return tblGame;
    }

    public void setTblGame(JTable tblGame) {
        this.tblGame = tblGame;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public ListController getListController() {
        return listController;
    }

    public void setListController(ListController listController) {
        this.listController = listController;
    }
}
