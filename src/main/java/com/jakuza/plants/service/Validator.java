package com.jakuza.plants.service;


import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.dao.ListingStatusJdbcDAO;
import com.jakuza.plants.dao.LocationJdbcDAO;
import com.jakuza.plants.dao.MarketplaceJdbcDAO;
import com.jakuza.plants.model.ListingStatus;
import com.jakuza.plants.model.Location;
import com.jakuza.plants.model.Marketplace;
import com.jakuza.plants.model.dto.ListingsDTO;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Validator
 */
@Service
@RequiredArgsConstructor
public class Validator {

    private final InvalidLineStore invalidLineStore;
    private final LocationJdbcDAO locationDao; 
    private final ListingStatusJdbcDAO statusDAO;
    private final MarketplaceJdbcDAO marketDAO;

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

        Optional<Location> loc = locationDao.get(item.getLocation_id());
        if(loc.isEmpty()){ 
            return false; 
        }

        Optional<ListingStatus> lst = statusDAO.get(item.getListing_status());
        if(lst.isEmpty()){
            return false;
        }

        Optional<Marketplace> mkt = marketDAO.get(item.getMarketplace());
        if(mkt.isEmpty()){
            return false;
        }

        if(item.getListing_price() <= 0 || 
                Double.toString(item.getListing_price()).split("\\.")[1].length() != 2){
            return false;
        }

        if (item.getCurrency().length() != 3) {
            return false;
        }

        if (item.getQuantity() <= 0){
            return false;
        }
        
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(item.getOwner_email_address());
        if(!matcher.matches()) {
            System.out.println("Wrong EMAIL");
            invalidLineStore.addInvalidLines(item, "email");
            return false;
        }

        return true;
    }

}
