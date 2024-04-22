package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Arrays;

public class AvgGameRatingsLL {
    private Node head;

    private Node tail;

    public AvgGameRatingsLL(){
        head = null;
        tail = null;
        createInitialElements();
        traverse();
    }
    public void addItem(Node itemToAdd){
        if(head == null){
            head = itemToAdd;
            tail = itemToAdd;
        } else if (head == tail) {
            if (head.avgRating > itemToAdd.avgRating){
                head.prev = itemToAdd;
                itemToAdd.next = head;
                head = itemToAdd;
            }
            else{
                head.next = itemToAdd;
                itemToAdd.prev = head;
                tail = itemToAdd;
            }

        } else{
            Node current = head;
            Node left = head;
            Node right = null;
            while(current != null){
                if (current.avgRating >= itemToAdd.avgRating){
                    left = current.prev;
                    right = current;
                    itemToAdd.prev = left;
                    itemToAdd.next = right;
                    left.next = itemToAdd;
                    right.prev = itemToAdd;
                    return;
                }
                current = current.next;
            }
            tail.next = itemToAdd;
            itemToAdd.prev = tail;
            tail = itemToAdd;

        }

    }
    public void traverse(){
        if(head == null){
            System.out.println("Empty Linked List");
        }
        else{
            Node current = head;
            while (current != null){
                System.out.println(current.value.getGameName() + " " + current.avgRating);
                current = current.next;
            }
        }
    }
    public void remove(String gameName){
        if(head == null){
            System.out.println("Empty Linked List");
        }
        else{
            Node current = head;
            Node left = null;
            Node right = null;
            while(current != null){
                if (current.value.getGameName().equals(gameName)){
                    left = current.prev;
                    right = current.next;

                    if(left == null){
                        head = right;
                        right.prev = null;
                        current.next = null;
                    }

                    else if (right == null) {
                        tail = left;
                        current.prev = null;
                        left.next = null;
                    }

                    else {
                        current.next = null;
                        current.prev = null;
                        left.next = right;
                        right.prev = left;
                    }
                }
                current = current.next;
            }
        }

    }

    public Game getItem(String gameName){
        if(head == null){
            System.out.println("Empty Linked List");
            return null;
        }
        else{
            Node current = head;
            while(current != null){
                if(current.value.getGameName().equals(gameName)){
                    System.out.println("Found game");
                    return current.value;
                }else{
                    current = current.next;

                }
            }
        }
        System.out.println("Did not find game with that name");
        return null;
    }

    public void updateItem(Game updatedGame){
        if(head == null){
            System.out.println("Empty Linked List");
        }
        else{
            Node current = head;
            while(current != null){
                if(current.value.getGameName().equals(updatedGame.getGameName())){
                    current.value = updatedGame;
                    System.out.println("Successfully found and updated node");
                    current.setAvgRating();
                    return;
                }

                current = current.next;
            }
            System.out.println("Did not find game to update");
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
        Game game1 = new Game("Minecraft", gameCompany1, "E", genres1, rating1, "Block based survival game", true);
        Game game2 = new Game("Skyrim", gameCompany2, "M", genres2, rating2, "Fantasy role playing game", false);
        Game game3 = new Game("Stardew Valley", gameCompany3, "E", genres3, rating3, "Fun farming simlulator with some fantasy elements", true);

        //Node creation
        Node g1 = new Node(game1);
        Node g2 = new Node(game2);
        Node g3 = new Node(game3);

        addItem(g3);
        addItem(g2);
        addItem(g1);

    }


}
