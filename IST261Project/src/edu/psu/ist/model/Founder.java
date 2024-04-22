package edu.psu.ist.model;

import java.util.ArrayList;

public class Founder implements SearchInformation {
    private String founderName;
    private Integer founderAge;
    private ArrayList<GameCompany> founderAtCompanies;

    public Founder(String founderName, Integer founderAge, ArrayList<GameCompany> founderAtCompanies) {
        this.founderName = founderName;
        this.founderAge = founderAge;
        this.founderAtCompanies = founderAtCompanies;
    }

    public Founder(String founderName, Integer founderAge){
        this.founderName = founderName;
        this.founderAge = founderAge;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public Integer getFounderAge() {
        return founderAge;
    }

    public void setFounderAge(Integer founderAge) {
        this.founderAge = founderAge;
    }

    public ArrayList<GameCompany> getFounderAtCompanies() {

        return founderAtCompanies;
    }
    public String getFounderAtCompaniesString(){
        if(this.founderAtCompanies == null){
            return "No companies found";
        }
        String companies = "Companies: ";

        for(int i =0; i < getFounderAtCompanies().size(); i++){
            companies = companies + this.founderAtCompanies.get(i).getName() + ", ";
        }
        return companies;
    }

    public void setFounderAtCompanies(ArrayList<GameCompany> founderAtCompanies) {
        this.founderAtCompanies = founderAtCompanies;
    }
    public void addFounderAtCompanies(GameCompany founderAtCompanies) {
        this.founderAtCompanies.add(founderAtCompanies);
    }

    @Override
    public String toString() {
        return "Founder{" +
                "founderName='" + founderName + '\'' +
                ", founderAge=" + founderAge +
                ", founderAtCompanies=" + getFounderAtCompaniesString() +
                '}';
    }

    @Override
    public String getInformationType() {
        return "This is \"Founder\"";
    }

    @Override
    public boolean getIsSearchable() {
        return false;
    }
}
