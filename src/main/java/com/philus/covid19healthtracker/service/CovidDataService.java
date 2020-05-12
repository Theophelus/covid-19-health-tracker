package com.philus.covid19healthtracker.service;
import com.google.gson.Gson;
import com.philus.covid19healthtracker.model.CountryStats;
import com.philus.covid19healthtracker.model.Global;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.JsonObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.*;

import static java.lang.String.valueOf;

@Service
public class CovidDataService {
    //Define a list to store AS stats
    static List<Global> saStats = new ArrayList<>();

    private final String COVID_19_URL = "https://api.covid19api.com/summary";

    // Define HttpClient
    private static HttpClient client;

    @PostConstruct
    @Scheduled(cron ="* * * 1 * *")
    public List<CountryStats> getCovidData(){
        //Create new Client
        client = HttpClient.newHttpClient();
        //Build client and request data from the api
        HttpRequest request = HttpRequest.newBuilder(URI.create(COVID_19_URL))
                .header("accep", "application/json")
                .GET()
                .build();

        //get response using the Async approach, which returns a completableFuture,
        // it takes two arguments, request and HttpResponse.BuildHandler.ofString which the
        //return type
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(CovidDataService::apply)
                .join();

        return null;
    }


    private static String apply(String res) {

         List<Global> stats = new ArrayList<>();
         List<CountryStats> countryStats = new ArrayList<>();

        CountryStats s_a = new CountryStats();
        Global global = new Global();

        try {
            JSONObject jsonObject = new JSONObject(res.trim());

            //Get Global Object
            JSONObject object = jsonObject.getJSONObject("Global");
            //set values in the list
            global.setNewRecovered(object.getInt("NewRecovered"));
            global.setNewDeaths(object.getInt("NewDeaths"));
            global.setTotalRecovered(object.getInt("TotalRecovered"));
            global.setTotalConfirmed(object.getInt("NewConfirmed"));
            global.setTotalDeaths(object.getInt("TotalDeaths"));
            global.setCountryStatsList(countryStats);

            final JSONArray countries = (JSONArray) jsonObject.get("Countries");

            for (int i = 0; i < countries.length(); i++) {

                JSONObject country = (JSONObject) countries.get(i);
                final String countryCode = country.getString("CountryCode");

                if (Objects.equals(countryCode, "ZA")) {
                    //call getData method
                    getData(s_a, country);

                }
            }
            countryStats.add(s_a);

            stats.add(global);

            System.out.println(stats);
            saStats = stats;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static void getData(CountryStats s_a, JSONObject country) throws JSONException {

        s_a.setCountry(country.getString("Country"));
        s_a.setNewConfirmed(country.getInt("NewConfirmed"));
        s_a.setTotalConfirmed(country.getInt("TotalConfirmed"));
        s_a.setNewDeaths(country.getInt("NewDeaths"));
        s_a.setTotalDeaths(country.getInt("TotalDeaths"));
        s_a.setNewRecovered(country.getInt("NewRecovered"));
        s_a.setTotalRecovered(country.getInt("TotalRecovered"));
        s_a.setDate( new Date());
    }

    public List<Global> getSaStats() {
        return saStats;
    }
}
