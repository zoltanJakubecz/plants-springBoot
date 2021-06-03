package com.jakuza.plants.controller;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.jakuza.plants.model.Plant;
import com.jakuza.plants.service.DataRetriver;

import org.springframework.stereotype.Component;

@Component
public class AppController {

     private final DataRetriver dataRetriver;

     public AppController(DataRetriver dataRetriver){
         this.dataRetriver = dataRetriver;
     }

    @PostConstruct
    public void appController(){
        Plant[] plants = dataRetriver.getDataFromAPI();
        Arrays.stream(plants).forEach((plant) -> {
            System.out.println(plant);
        });
    }
    
}
