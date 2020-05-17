package com.philus.covid19healthtracker.models;

import java.util.List;

public class Global {

    private int NewConfirmed;
    private int TotalConfirmed;
    private int newDeaths;
    private int TotalDeaths;
    private int NewRecovered;
    private int TotalRecovered;
    private List<CountryStats> countryStats;

    public Global(){}
    public Global(int newConfirmed, int totalConfirmed, int newDeaths, int totalDeath, int newRecovered, int totalRecovered, List<CountryStats> countryStats) {
        this.NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.TotalDeaths = totalDeath;
        this.NewRecovered = newRecovered;
        this.TotalRecovered = totalRecovered;
        this.countryStats = countryStats;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.TotalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.NewRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.TotalRecovered = totalRecovered;
    }

    public List<CountryStats> getCountryStatsList() {
        return countryStats;
    }

    public void setCountryStatsList(List<CountryStats> countryStats) {
        this.countryStats = countryStats;
    }

    @Override
    public String toString() {
        return "Global{" +
                "newConfirmed=" + NewConfirmed +
                ", TotalConfirmed=" + TotalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeath=" + TotalDeaths +
                ", newRecovered=" + NewRecovered +
                ", totalRecovered=" + TotalRecovered +
                ", countryStats=" + countryStats +
                '}';
    }
}
