package com.jakuza.plants.model.dto;


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

	private String month;
  private String name;
	private int count;
	private double mTotalPrice;

	
}
