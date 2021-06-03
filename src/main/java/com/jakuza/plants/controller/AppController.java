package com.jakuza.plants.controller;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.jakuza.plants.dao.ListingJdbcDAO;
import com.jakuza.plants.model.Plant;
import com.jakuza.plants.service.DataRetriver;

import org.springframework.stereotype.Component;

@Component
public class AppController {

     private final DataRetriver dataRetriver;
     private final ListingJdbcDAO listingJdbcDAO;

     public AppController(DataRetriver dataRetriver, ListingJdbcDAO listingJdbcDAO){
         this.dataRetriver = dataRetriver;
         this.listingJdbcDAO = listingJdbcDAO;
     }

    @PostConstruct
    public void appController(){
        Plant[] plants = dataRetriver.getDataFromAPI();
        Arrays.stream(plants).forEach((plant) -> {
//            System.out.println(plant);
            listingJdbcDAO.create(plant);
        });
    }
    
}
