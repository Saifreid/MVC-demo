package edu.psu.ist.test;
import edu.psu.ist.model.Founder;
import edu.psu.ist.model.GameCompany;

import java.util.ArrayList;

public class FounderTest {



    public static void main(String[] args) {
        ArrayList<GameCompany> gameCompany1 = new ArrayList<>();
        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("RPG");
        genres1.add("Fantasy");
        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("RPG");
        genres2.add("Fantasy");
        genres2.add("Strategy");
        GameCompany bethesda = new GameCompany("Bethesda", "Med", "CA", 1996, genres1);
        GameCompany larianStudios = new GameCompany("Larian Studios", "SM", "CA", 2000, genres2);
        gameCompany1.add(bethesda);
        Founder founder1 = new Founder("Todd Howard", 56, gameCompany1);
        Founder founder2 = new Founder("Jeremy Benning", 78, gameCompany1);
        System.out.println(founder1.toString());
        founder1.addFounderAtCompanies(larianStudios);
        founder1.setFounderAge(57);
        founder1.setFounderName("Todd Howardest");
        System.out.println(founder1.toString());

    }
}
