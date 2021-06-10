package com.jakuza.plants.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakuza.plants.dao.CsvWriter;
import com.jakuza.plants.dao.ListingJdbcDAO;
import com.jakuza.plants.dao.ListingStatusJdbcDAO;
import com.jakuza.plants.dao.LocationJdbcDAO;
import com.jakuza.plants.dao.MarketplaceJdbcDAO;
import com.jakuza.plants.dao.ReportJdbcDAO;
import com.jakuza.plants.model.ListingStatus;
import com.jakuza.plants.model.Listings;
import com.jakuza.plants.model.Location;
import com.jakuza.plants.model.Marketplace;
import com.jakuza.plants.model.dto.ListingsDTO;
import com.jakuza.plants.model.dto.ReportFullDTO;
import com.jakuza.plants.service.DataRetriver;
import com.jakuza.plants.service.InvalidLineStore;
import com.jakuza.plants.service.Report;
import com.jakuza.plants.service.Validator;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppController {

     private final DataRetriver dataRetriver;
     private final ListingJdbcDAO listingDAO;
     private final LocationJdbcDAO locationDAO;
     private final MarketplaceJdbcDAO marketDAO;
     private final ListingStatusJdbcDAO statusDAO;
     private final ReportJdbcDAO reportDAO;
     private final Validator validator;
     private final InvalidLineStore invalidLines;
     private final CsvWriter csvWriter;
     private final Report report;


    @PostConstruct
    public void appController(){
        ObjectMapper mapper = new ObjectMapper();

        
        Object[] objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/location?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Location.class))
                .forEach(locationDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/listingStatus?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, ListingStatus.class))
                .forEach(statusDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/marketplace?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Marketplace.class))
                .forEach(marketDAO::create);


        objects = dataRetriver.getDataFromAPI("https://my.api.mockaroo.com/listing?key=63304c70");
        Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, ListingsDTO.class))
                .filter(listingDTO -> validator.isValid(listingDTO))
                .map(item -> Listings.fromDTO(item))
                .forEach(listingDAO::create);

        csvWriter.saveToFile(invalidLines.getInvalidLines());


        List<ReportFullDTO> reportList = reportDAO.getReport();
        report.createReport(reportList);
    }


    
}
