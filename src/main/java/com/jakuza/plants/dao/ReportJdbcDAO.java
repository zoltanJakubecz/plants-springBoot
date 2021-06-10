package com.jakuza.plants.dao;

import java.util.List;
import com.jakuza.plants.model.dto.ReportFullDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
/**
* ReportJdbcDAO
*/
@Component
@RequiredArgsConstructor
public class ReportJdbcDAO {

	private final JdbcTemplate jdbcTemplate;
	
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
