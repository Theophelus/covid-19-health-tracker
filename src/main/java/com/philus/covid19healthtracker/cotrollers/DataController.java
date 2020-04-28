package com.philus.covid19healthtracker.cotrollers;


import com.philus.covid19healthtracker.model.CountryStats;
import com.philus.covid19healthtracker.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DataController {

    @Autowired
     final CovidDataService covidDataService;

    public DataController(CovidDataService covidDataService) {
        this.covidDataService = covidDataService;
    }

    @RequestMapping(value = "/data", produces = "application/json", method = RequestMethod.GET)
    public List<CountryStats> getData(){

        return covidDataService.getSaStats();

    }

}
