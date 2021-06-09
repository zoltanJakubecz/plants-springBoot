package com.jakuza.plants.dao;

import java.util.Optional;

import com.jakuza.plants.model.ListingStatus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListingStatusJdbcDAO{

	private final JdbcTemplate jdbcTemplate;

	RowMapper<ListingStatus> rowMapper = (rs, rowNum) -> {
		ListingStatus status = new ListingStatus();
		status.setId(rs.getInt("id"));
		status.setStatus_name(rs.getString("status_name"));
		return status;
	};



	public void create(ListingStatus listingStatus) {
	String sql =	"INSERT INTO status(id, status_name) VALUES (?,?)";
	jdbcTemplate.update(sql, listingStatus.getId(), listingStatus.getStatus_name());
	}


	public Optional<ListingStatus> get(int id) {

		String sql = "SELECT * from status WHERE id = ?";
		ListingStatus status = null;

		try {
			status = jdbcTemplate.queryForObject(sql , rowMapper, new Object[]{id});
		} catch (Exception e) {
			System.out.println("Status not found: " + id);
		}

		return Optional.ofNullable(status);

	}


}
