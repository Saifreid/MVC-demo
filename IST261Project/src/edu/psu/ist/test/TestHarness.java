package edu.psu.ist.test;
import edu.psu.ist.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestHarness {




    public static void testClassHierarchy(){
        ArrayList<Game> gameList = new ArrayList<>();
        Founder notFullFounder = new Founder("Spencer Thomas", 21);
        System.out.println(notFullFounder);
        ArrayList<GameCompany> gameCompanyList1 = new ArrayList<>();
        ArrayList<GameCompany> gameCompanyList2 = new ArrayList<>();
        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("RPG");
        genres1.add("Fantasy");
        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("RPG");
        genres2.add("Fantasy");
        genres2.add("Strategy");
        GameCompany gameCompany1 = new GameCompany("Bethesda", "Med", "CA", 1996, genres1);
        GameCompany gameCompany2 = new GameCompany("Larian Studios", "SM", "CA", 2000, genres2);
        gameCompanyList1.add(gameCompany1);
        gameCompanyList2.add(gameCompany1);
        Founder founder1 = new Founder("Todd Howard", 56, gameCompanyList1);
        Founder founder2 = new Founder("Jeremy Benning", 78, gameCompanyList1);
        founder1.addFounderAtCompanies(gameCompany2);
        founder1.setFounderAtCompanies(gameCompanyList2);

        //This is GameCompany test
        ArrayList<Founder> founderList1 = new ArrayList<>();
        founderList1.add(founder1);
        GameCompany fullGameCompany = new GameCompany("Jackbox", "SM", "NY", 2002, founderList1, genres1);
        gameCompany1.setName("Gearbox");
        gameCompany1.setSize("LG");
        gameCompany1.setLocation("PA");
        gameCompany1.setEstablished(1999);
        gameCompany1.setFounders(founderList1);
        gameCompany1.setGenres(genres2);
        ArrayList<Double> game1Ratings = new ArrayList<>(List.of(99.00, 99.0));
        ArrayList<Double> game2Ratings = new ArrayList<>(List.of(99.00, 95.0));


        MultiplayerGame mG1 = new MultiplayerGame("Minecraft", gameCompany1, "E", genres1, game1Ratings,"Blocks", 100);
        SinglePlayerGame sG1 = new SinglePlayerGame("Skyrim", gameCompany1, "M", genres2, game2Ratings, "Fantasy RolePlayingGame");
        gameList.add(mG1);
        gameList.add(sG1);
        for(Game game : gameList){
            System.out.println(game.isThisMultiplayer());
            System.out.println(game.toString());
        }
    }
    public static void testInterface() {
        ArrayList<PlayerGame> playerGameList = new ArrayList<>();
        ArrayList<GameCompany> gameCompanyList1 = new ArrayList<>();
        ArrayList<GameCompany> gameCompanyList2 = new ArrayList<>();
        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("RPG");
        genres1.add("Fantasy");
        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("RPG");
        genres2.add("Fantasy");
        genres2.add("Strategy");
        GameCompany gameCompany1 = new GameCompany("Bethesda", "Med", "CA", 1996, genres1);
        GameCompany gameCompany2 = new GameCompany("Larian Studios", "SM", "CA", 2000, genres2);
        gameCompanyList1.add(gameCompany1);
        gameCompanyList2.add(gameCompany1);
        Founder founder1 = new Founder("Todd Howard", 56, gameCompanyList1);
        Founder founder2 = new Founder("Jeremy Benning", 78, gameCompanyList1);
        founder1.addFounderAtCompanies(gameCompany2);
        founder1.setFounderAtCompanies(gameCompanyList2);

        //This is GameCompany test
        ArrayList<Founder> founderList1 = new ArrayList<>();
        founderList1.add(founder1);
        GameCompany fullGameCompany = new GameCompany("Jackbox", "SM", "NY", 2002, founderList1, genres1);
        gameCompany1.setName("Gearbox");
        gameCompany1.setSize("LG");
        gameCompany1.setLocation("PA");
        gameCompany1.setEstablished(1999);
        gameCompany1.setFounders(founderList1);
        gameCompany1.setGenres(genres2);
        ArrayList<Double> game1Ratings = new ArrayList<>(List.of(99.00, 99.0));
        ArrayList<Double> game2Ratings = new ArrayList<>(List.of(99.00, 95.0));

        MultiplayerGame mG1 = new MultiplayerGame("Minecraft", gameCompany1, "E", genres1, game1Ratings, "Blocks", 100);
        SinglePlayerGame sG1 = new SinglePlayerGame("Skyrim", gameCompany1, "M", genres2, game2Ratings, "Fantasy RolePlayingGame");
        ArrayList<SearchInformation> searchInfoList = new ArrayList<>();
        searchInfoList.add(founder1);
        searchInfoList.add(mG1);
        for(SearchInformation searchInfo: searchInfoList){
            System.out.println(searchInfo.getInformationType());
            System.out.println(searchInfo.getIsSearchable());
        }
    }

    public static void main(String[] args) {

        //This is Interface test
        testInterface();
        //This is Class Hierarchy test
        testClassHierarchy();
        //Founder Test
        Founder notFullFounder = new Founder("Spencer Thomas", 21);
        System.out.println(notFullFounder);
        ArrayList<GameCompany> gameCompanyList1 = new ArrayList<>();
        ArrayList<GameCompany> gameCompanyList2 = new ArrayList<>();
        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("RPG");
        genres1.add("Fantasy");
        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("RPG");
        genres2.add("Fantasy");
        genres2.add("Strategy");
        GameCompany gameCompany1 = new GameCompany("Bethesda", "Med", "CA", 1996, genres1);
        GameCompany gameCompany2 = new GameCompany("Larian Studios", "SM", "CA", 2000, genres2);
        gameCompanyList1.add(gameCompany1);
        gameCompanyList2.add(gameCompany1);
        Founder founder1 = new Founder("Todd Howard", 56, gameCompanyList1);
        Founder founder2 = new Founder("Jeremy Benning", 78, gameCompanyList1);
        System.out.println(founder1.toString());
        founder1.addFounderAtCompanies(gameCompany2);
        founder1.setFounderAge(57);
        founder1.setFounderName("Todd Howardest");
        System.out.println(founder1.toString());
        System.out.println(founder1.getFounderName());
        System.out.println(founder1.getFounderAge());
        System.out.println(founder1.getFounderAtCompaniesString());
        founder1.setFounderAtCompanies(gameCompanyList2);
        System.out.println(founder1.toString());

        //This is GameCompany test
        ArrayList<Founder> founderList1 = new ArrayList<>();
        founderList1.add(founder1);
        GameCompany fullGameCompany = new GameCompany("Jackbox", "SM", "NY", 2002, founderList1, genres1);
        System.out.println(fullGameCompany);
        System.out.println(gameCompany1);
        gameCompany1.setName("Gearbox");
        gameCompany1.setSize("LG");
        gameCompany1.setLocation("PA");
        gameCompany1.setEstablished(1999);
        gameCompany1.setFounders(founderList1);
        gameCompany1.setGenres(genres2);
        System.out.println(gameCompany1);
        System.out.println(gameCompany1.getName());
        System.out.println(gameCompany1.getSize());
        System.out.println(gameCompany1.getLocation());
        System.out.println(gameCompany1.getEstablished());
        System.out.println(gameCompany1.getFoundersString());
        System.out.println(gameCompany1.getFounders());
        System.out.println(gameCompany1.getGenres());

    }

}
