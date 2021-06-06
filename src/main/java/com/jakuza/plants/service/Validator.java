package com.jakuza.plants.service;


import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.dao.DAO;
import com.jakuza.plants.model.Location;
import com.jakuza.plants.model.dto.ListingsDTO;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Validator
 */
@Service
@RequiredArgsConstructor
public class Validator {

    private final DAO<Location> locationDao; 

    public boolean isValid(Object object){

        ObjectMapper mapper = new ObjectMapper();
            ListingsDTO item = mapper.convertValue(object, ListingsDTO.class);

        try {
            UUID.fromString(item.getId());
        } catch (Exception e) {
            return false;
        }

        if(item.getTitle() == null || item.getTitle().equals("")){
            return false;
        }

        Optional<Location> loc = locationDao.get(UUID.fromString(item.getLocation_id()));
        if(loc.isEmpty()){ 
            return false; 
        }
        return true;
    }
    
}
