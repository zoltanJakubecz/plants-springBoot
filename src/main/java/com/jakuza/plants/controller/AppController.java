package com.jakuza.plants.controller;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.model.Listings;
import com.jakuza.plants.service.DataRetriver;

import org.springframework.stereotype.Component;

@Component
public class AppController {

     private final DataRetriver dataRetriver;
//     private final ListingJdbcDAO listingJdbcDAO;

     public AppController(DataRetriver dataRetriver){
         this.dataRetriver = dataRetriver;
//         this.listingJdbcDAO = listingJdbcDAO;
     }

    @PostConstruct
    public void appController(){
        ObjectMapper mapper = new ObjectMapper();

        Object[] objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/listing?key=63304c70");

        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Listings.class))
                .forEach(System.out::println);
//        Arrays.stream(plants).forEach(listingJdbcDAO::create);
    }
    
}
