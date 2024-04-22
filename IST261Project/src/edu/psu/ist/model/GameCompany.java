package edu.psu.ist.model;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.io.Serializable;

public class GameCompany implements Serializable{
    private String name;
    private String size;
    private String location;
    private Integer established;
    private ArrayList<Founder> founders;
    private ArrayList<String> genres;

    public GameCompany(String name, String size, String location, Integer established, ArrayList<Founder> founders, ArrayList<String> genres) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.established = established;
        this.founders = founders;
        this.genres = genres;
    }

    public GameCompany(String name, String size, String location, Integer established, ArrayList<String> genres) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.established = established;
        this.genres = genres;
    }
    public GameCompany(String name, String size, String location, Integer established) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.established = established;
    }
    public GameCompany(){
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEstablished() {
        return established;
    }

    public void setEstablished(Integer established) {
        this.established = established;
    }

    public ArrayList<Founder> getFounders() {
        return founders;
    }

    public void setFounders(ArrayList<Founder> founders) {
        this.founders = founders;
    }

    public String getFoundersString(){
        String foundersString = "";
        if (founders == null){
            return "No founders found";
        }
        for(int i = 0; i < founders.size(); i++ ){
            foundersString += "" + this.founders.get(i).getFounderName();
        }
        return foundersString;
    }
    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GameCompany{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", location='" + location + '\'' +
                ", established=" + established +
                ", founders= " + getFoundersString() +
                ", genres=" + genres +
                '}';
    }
}
