package com.jakuza.plants.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(includeFieldNames = false)
public class Listings {

	private UUID id;
	private String title;
	private String description;
	private UUID location_id;
	private double listing_price;
	private String currency;
	private int quantity;
	private int listing_status;
	private int marketplace;
	private String upload_time;
	private String owner_email_address;

}