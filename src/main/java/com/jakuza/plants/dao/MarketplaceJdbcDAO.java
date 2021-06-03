package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.Marketplace;

import org.springframework.jdbc.core.JdbcTemplate;

public class MarketplaceJdbcDAO implements DAO<Marketplace>{

	private final JdbcTemplate jdbcTemplate;

	public MarketplaceJdbcDAO(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Marketplace> list(){
		return null;
	}

	@Override
	public void create(Marketplace marketplace){
		String sql = "INSERT INTO marketplace(id, marketplace_name) VALUES (?,?)";
		jdbcTemplate.update(sql, marketplace.getId(), marketplace.getMarketplace_name());
	}

	@Override
	public Optional<Marketplace> get(UUID id){
		return null;
	}
}
