package com.jakuza.plants.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* ReportMonthlyDTO
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportMonthlyDTO {

	private LocalDate month;
  private String name;
	private double mTotalPrice;

	
}
