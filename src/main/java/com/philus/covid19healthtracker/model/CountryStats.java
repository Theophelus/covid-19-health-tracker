package com.philus.covid19healthtracker.model;

public class CountryStats {


    private  String country;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int active;
    private int critical;
    private int tests;



    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }


//    public CountryStats(String country, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active, int critical, int tests) {
//        this.country = country;
//        this.cases = cases;
//        this.todayCases = todayCases;
//        this.deaths = deaths;
//        this.todayDeaths = todayDeaths;
//        this.recovered = recovered;
//        this.active = active;
//        this.critical = critical;
//        this.tests = tests;
//    }

    public String getCountry() {
        return country;
    }

    public int getCases() {
        return cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getActive() {
        return active;
    }

    public int getCritical() {
        return critical;
    }

    public int getTests() {
        return tests;
    }


    @Override
    public String toString() {
        return "CountryStats{" +
                "country='" + country + '\'' +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", active=" + active +
                ", critical=" + critical +
                ", tests=" + tests +
                '}';
    }


}
