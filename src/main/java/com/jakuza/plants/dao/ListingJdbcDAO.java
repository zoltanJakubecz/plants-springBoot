package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.Listings;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ListingJdbcDAO implements DAO<Listings>{

	private JdbcTemplate jdbcTemplate;

	public ListingJdbcDAO(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Listings> list(){
		return null;
	};

	@Override
	public void create(Listings listings){
		String sql = "INSERT INTO listing(" + 
				"id, title, description, inventory_item_location_id," +
				" listing_price, currency, quantity, listing_status," + 
				" marketplace, upload_time, owner_email_address) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, listings.getId(), listings.getTitle(), listings.getDescription(),
				listings.getLocation_id(), listings.getListing_price(), listings.getCurrency(),
				listings.getQuantity(), listings.getListing_status(), listings.getMarketplace(), listings.getUpload_time(), listings.getOwner_email_address());
	}

	@Override
	public Optional<Listings> get(UUID id){
		return null;
	}
}
