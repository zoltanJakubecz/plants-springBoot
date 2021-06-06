package com.jakuza.plants.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jakuza.plants.model.ListingStatus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListingStatusJdbcDAO implements DAO<ListingStatus> {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<ListingStatus> list() {
		return null;
	}

	@Override
	public void create(ListingStatus listingStatus) {
	String sql =	"INSERT INTO status(id, status_name) VALUES (?,?)";
	jdbcTemplate.update(sql, listingStatus.getId(), listingStatus.getStatus_name());
	}

	@Override
	public Optional<ListingStatus> get(UUID id) {
		return null;
	}



}
