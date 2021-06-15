package com.jakuza.plants.dao;

import java.util.List;
import com.jakuza.plants.model.dto.ReportFullDTO;
import com.jakuza.plants.model.dto.ReportMonthlyDTO;

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

	/*
	public List<ReportFullDTO> getReport() {

		String sql = "SELECT marketplace_name, COUNT(listing.id), ROUND(SUM(listing_price)::numeric, 2) as  sum_price from listing JOIN marketplace ON listing.marketplace = marketplace.id GROUP BY marketplace_name;";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
				ReportFullDTO report = new ReportFullDTO();
				report.setName(rs.getString("marketplace_name"));
				report.setCount(rs.getInt("count"));
				report.setTotalPrice(rs.getDouble("sum_price"));
				return report;
		});
	}
*/
	public List<ReportMonthlyDTO> getReportMonthly() {

		String sql = "SELECT date_trunc('month', listing.upload_time) as month, " 
			+ "marketplace_name, " 
			+ "COUNT(listing.id), "
			+ "ROUND(sum(listing_price)::numeric, 2) " 
			+ "FROM listing JOIN marketplace "
			+ "ON listing.marketplace = marketplace.id "
			+ "GROUP BY date_trunc('month', listing.upload_time), marketplace_name "
			+ "ORDER BY month, marketplace_name asc;";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ReportMonthlyDTO report = new ReportMonthlyDTO();
			report.setMonth(rs.getString("month"));
			report.setName(rs.getString("marketplace_name"));
			report.setCount(rs.getInt("count"));
			report.setMTotalPrice(rs.getDouble("round"));
			return report;
		});
	}		

}
