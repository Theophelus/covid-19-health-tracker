package com.philus.covid19healthtracker.service;

import com.philus.covid19healthtracker.model.CountryStats;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.String.valueOf;

@Service
public class CovidDataService {



    //Define a list to store AS stats
   static List<CountryStats> saStats = new ArrayList<>();

    private final String COVID_19_URL = "https://corona.lmao.ninja/v2/countries/South%20Africa";
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
         List<CountryStats> stats = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(res.trim());

            Iterator<?> iterator = jsonObject.keys();

            while (iterator.hasNext()) {
                CountryStats   countryStat = new CountryStats();

                countryStat.setCountry(jsonObject.getString("country"));
                countryStat.setCases(jsonObject.getInt("cases"));
                countryStat.setTodayCases(jsonObject.getInt("todayCases"));
                countryStat.setDeaths(jsonObject.getInt("deaths"));
                countryStat.setTodayDeaths(jsonObject.getInt("todayDeaths"));
                countryStat.setRecovered(jsonObject.getInt("recovered"));
                countryStat.setActive(jsonObject.getInt("active"));
                countryStat.setCritical(jsonObject.getInt("critical"));
                countryStat.setTests(jsonObject.getInt("tests"));

                stats.add(countryStat);
                break;
            }

            System.out.println(stats);
            saStats = stats;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<CountryStats> getSaStats() {
        return saStats;
    }

}
