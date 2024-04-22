package edu.psu.ist;

import edu.psu.ist.controller.GameController;
import edu.psu.ist.controller.ListController;
import edu.psu.ist.model.AvgGameRatingsLL;
import edu.psu.ist.model.Game;
import edu.psu.ist.model.Queue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //GameController gameController = new GameController();
        new ListController();
        AvgGameRatingsLL ll1 = new AvgGameRatingsLL();
        ll1.remove("Skyrim");
        System.out.println();
        ll1.traverse();
        ll1.getItem("Minecraft");
        ll1.getItem("palsd");
        ArrayList<Double> ratingList1 = new ArrayList<>();
        Game gameToUpdate = ll1.getItem("Stardew Valley");
        gameToUpdate.getRatings().add(97.0);
        ll1.updateItem(gameToUpdate);
        System.out.println();
        ll1.traverse();
        System.out.println();


        //Collections assignment with a queue

        Queue queue1 = new Queue();
        queue1.traverse();
        Game game1 = queue1.getGame1();
        Game game2 = queue1.getGame2();
        Game game3 = queue1.getGame3();
        System.out.println("Using getItem() with items: " + queue1.getItem());
        queue1.updateItem(game1, game3);
        System.out.println("Using getItem() after updating game1(next out in queue): " + queue1.getItem());
        queue1.removeItem();
        System.out.println("Using getItem() after removing the next in queue: " + queue1.getItem());

    }
}
