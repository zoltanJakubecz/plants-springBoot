package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.Location;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class LocationJdbcDAO implements DAO<Location> {

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Location> rowMapper = (rs, rowNum) -> {

        Location location = new Location();
        location.setId(UUID.fromString(rs.getString("id")));
        location.setManager_name(rs.getString("manager_name"));
        location.setPhone(rs.getString("phone"));
        location.setAddress_primary(rs.getString("address_primary"));
        location.setAddress_secondary(rs.getString("address_secondary"));
        location.setCountry(rs.getString("country"));
        location.setTown(rs.getString("town"));
        location.setPostal_code(rs.getString("postal_code"));
        return location;

    };

    @Override
    public List<Location> list() {
        return null;
    }

    @Override
    public void create(Location location) {

        String sql = "INSERT INTO location(id, manager_name, phone, address_primary, address_secondary, country, town, postal_code) VALUES (?,?,?,?,?,?,?,?)"; 
        int insert = jdbcTemplate.update(sql, location.getId(), location.getManager_name(), 
                                    location.getPhone(), location.getAddress_primary(), 
                                    location.getAddress_secondary(), location.getCountry(), 
                                    location.getTown(), location.getPostal_code());

        if(insert == 1){
            System.out.println("New location added " + location.getManager_name());
        }

    }

    @Override
    public Optional<Location> get(UUID id) {

        String sql = "SELECT * from location WHERE id = ?";
        Location location = null;

        try {
            location = jdbcTemplate.queryForObject(sql, rowMapper , new Object[]{id});
        } catch (Exception e) {
            System.out.println("Location not found : " + id);
        }

        return Optional.ofNullable(location);
    }

    
}
