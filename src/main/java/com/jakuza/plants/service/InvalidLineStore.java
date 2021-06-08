package com.jakuza.plants.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jakuza.plants.dao.MarketplaceJdbcDAO;
import com.jakuza.plants.model.Marketplace;
import com.jakuza.plants.model.dto.ListingsDTO;

import org.springframework.stereotype.Service;

/**
 * InvalidLineStore
 */
@Service
public class InvalidLineStore {

    private MarketplaceJdbcDAO marketDAO;
    private static List<String[]> invalidLines = new ArrayList<>();

    
    public InvalidLineStore(MarketplaceJdbcDAO marketDAO){
        this.marketDAO = marketDAO;
    }

    public List<String[]> getInvalidLines(){

        return invalidLines;

    }


    public void addInvalidLines(ListingsDTO item){
            Optional<Marketplace> mkt = marketDAO.get(item.getMarketplace()); 
            invalidLines.add(new String[]{item.getId(),mkt.get().getMarketplace_name(), "email"});
            
    }

}
