package com.jakuza.plants.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataRetriver {
    
    private final RestTemplate restTemplate;

    DataRetriver(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Object[] getDataFromAPI(String url){
        
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
        return response.getBody();
        
    }
}
