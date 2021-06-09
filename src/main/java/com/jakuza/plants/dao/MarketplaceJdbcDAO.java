package com.jakuza.plants.dao;

import java.util.Optional;
import com.jakuza.plants.model.Marketplace;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MarketplaceJdbcDAO{

	private final JdbcTemplate jdbcTemplate;

 	RowMapper<Marketplace> rowMapper = (rs, rowNum) -> {
		Marketplace market = new Marketplace();
		market.setId(rs.getInt("id"));
		market.setMarketplace_name(rs.getString("marketplace_name"));
		return market;
	};

	public MarketplaceJdbcDAO(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public void create(Marketplace marketplace){
		String sql = "INSERT INTO marketplace(id, marketplace_name) VALUES (?,?)";
		jdbcTemplate.update(sql, marketplace.getId(), marketplace.getMarketplace_name());
	}

	public Optional<Marketplace> get(int id){
		String sql = "SELECT * FROM marketplace WHERE id = ?";
		Marketplace market = null;
		try {
			market = jdbcTemplate.queryForObject(sql , rowMapper, new Object[]{id});
		} catch (Exception e) {
			System.out.println("MarketPlace not found: " + id);
		}
		return Optional.ofNullable(market);
	}
}
