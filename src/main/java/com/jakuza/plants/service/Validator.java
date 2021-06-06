package com.jakuza.plants.service;


import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.model.dto.ListingsDTO;

import org.springframework.stereotype.Service;

/**
 * Validator
 */
@Service
public class Validator {

    public boolean isValid(Object object){
        ObjectMapper mapper = new ObjectMapper();

        try {
            ListingsDTO item = mapper.convertValue(object, ListingsDTO.class);
            UUID uuid = UUID.fromString(item.getId());
            return true;
        } catch (Exception e) {
            return false;
            //TODO: handle exception
        }
    }
    
}
