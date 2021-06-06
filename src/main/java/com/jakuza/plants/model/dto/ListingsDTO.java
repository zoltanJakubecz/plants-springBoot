package com.jakuza.plants.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* ListingsDTO
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListingsDTO {

	private String id;
	private String title;
	private String description;
	private String location_id;
	private double listing_price;
	private String currency;
	private int quantity;
	private int listing_status;
	private int marketplace;
	private String upload_time;
	private String owner_email_address;

}
