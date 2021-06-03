package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.Plant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ListingJdbcDAO implements DAO<Plant>{

	private JdbcTemplate jdbcTemplate;

	public ListingJdbcDAO(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Plant> list(){
		return null;
	};

	@Override
	public void create(Plant plant){
		String sql = "INSERT INTO listing(" + 
				"id, title, description, inventory_item_location_id," + 
				" listing_price, currency, quantity, listing_status," + 
				" marketplace, upload_time, owner_email_address) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,plant.getId(), plant.getTitle(), plant.getDescription(),
				plant.getInvertory_item_location(), plant.getListing_price(), plant.getCurrency(),
				plant.getQuantity(), plant.getListing_status(), plant.getMarketplace(), plant.getUpload_time(),plant.getOwner_email_address());
	}

	@Override
	public Optional<Plant> get(UUID id){
		return null;
	}
}
