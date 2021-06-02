package com.jakuza.plants.service;

import com.jakuza.plants.model.Plant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DataRetriver {
    
    private final RestTemplate restTemplate;

    DataRetriver(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Plant[] getDataFromAPI(){
        
        ResponseEntity<Plant[]> response = restTemplate.getForEntity("https://my.api.mockaroo.com/listing?key=63304c70", Plant[].class);
        return response.getBody();
        
    }
}
