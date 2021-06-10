package com.jakuza.plants.dao;

import java.util.List;

import com.jakuza.plants.model.Listings;
import com.jakuza.plants.model.dto.ReportFullDTO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListingJdbcDAO{

	private final JdbcTemplate jdbcTemplate;



	public void create(Listings listings){
		String sql = "INSERT INTO listing(" + 
				"id, title, description, inventory_item_location_id," +
				" listing_price, currency, quantity, listing_status," + 
				" marketplace, upload_time, owner_email_address) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, listings.getId(), listings.getTitle(), listings.getDescription(),
				listings.getLocation_id(), listings.getListing_price(), listings.getCurrency(),
				listings.getQuantity(), listings.getListing_status(), listings.getMarketplace(), listings.getUpload_time(), listings.getOwner_email_address());
	}


	public List<ReportFullDTO> getReport() {

		String sql = "SELECT marketplace_name, COUNT(listing.id), ROUND(SUM(listing_price)::numeric, 2) as  sum_price from listing JOIN marketplace ON listing.marketplace = marketplace.id GROUP BY marketplace_name";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
				ReportFullDTO report = new ReportFullDTO();
				report.setName(rs.getString("marketplace_name"));
				report.setCount(rs.getInt("count"));
				report.setTotalPrice(rs.getDouble("sum_price"));
				return report;
		});
	}

}
