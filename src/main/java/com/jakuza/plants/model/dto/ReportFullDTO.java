package com.jakuza.plants.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* ReportFullDTO
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportFullDTO {

	private String name;
	private int count;
	private double totalPrice;

}
