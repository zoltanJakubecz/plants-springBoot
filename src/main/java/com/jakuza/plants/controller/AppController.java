package com.jakuza.plants.controller;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.dao.DAO;
import com.jakuza.plants.model.ListingStatus;
import com.jakuza.plants.model.Listings;
import com.jakuza.plants.model.Location;
import com.jakuza.plants.model.Marketplace;
import com.jakuza.plants.service.DataRetriver;
import com.jakuza.plants.service.Validator;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppController {

     private final DataRetriver dataRetriver;
     private final DAO<Listings> listingDAO;
     private final DAO<Location> locationDAO;
     private final DAO<Marketplace> marketDAO;
     private final DAO<ListingStatus> statusDAO;
     private final Validator validator;


    @PostConstruct
    public void appController(){
        ObjectMapper mapper = new ObjectMapper();

        
        Object[] objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/location?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Location.class))
//                .forEach(System.out::println);
                .forEach(locationDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/listingStatus?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, ListingStatus.class))
//                .forEach(System.out::println);
                .forEach(statusDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/marketplace?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Marketplace.class))
//                .forEach(System.out::println);
                .forEach(marketDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/listing?key=63304c70");
        Arrays.stream(objects)
                .filter(object -> validator.isValid(object))
                .map(object -> mapper.convertValue(object, Listings.class))
                .forEach(System.out::println);
//                    .forEach(listingDAO::create);
               
    }
    
}
