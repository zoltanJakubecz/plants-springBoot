package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.Location;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class LocationJdbcDAO implements DAO<Location> {

    private final JdbcTemplate jdbcTemplate;
    

    @Override
    public List<Location> list() {
        return null;
    }

    @Override
    public void create(Location location) {
        String sql = "INSERT INTO location(id, manager_name, phone, address_primary, address_secondary, country, town, postal_code) VALUES (?,?,?,?,?,?,?,?)"; 
        int insert = jdbcTemplate.update(sql, location.getId(), location.getManager_name(), location.getPhone(), location.getAddress_primary(), location.getAddress_secondary(), location.getCountry(), location.getTown(), location.getPostal_code());
        if(insert == 1){
            System.out.println("New location added " + location.getManager_name());
        }
    }

    @Override
    public Optional<Location> get(UUID id) {
        return null;
    }

    
}
