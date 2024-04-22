package edu.psu.ist.model;
import edu.psu.ist.model.Game;



public class Node {
    public Game value;
    public Double avgRating;

    // reference attribute for the next Node
    public Node next;
    public Node prev;

    public Node(Game value){
        this.value = value;
        this.avgRating = 0.0;
        for(Double rating: this.value.getRatings()){
            avgRating += rating;
        }
        avgRating = (avgRating/this.value.getRatings().size());
        this.next = null;
        this.prev = null;
    }
    public void setAvgRating(){
        this.avgRating = 0.0;
        for(Double rating: this.value.getRatings()){
            avgRating += rating;
        }
        avgRating = (avgRating/this.value.getRatings().size());

    }
}