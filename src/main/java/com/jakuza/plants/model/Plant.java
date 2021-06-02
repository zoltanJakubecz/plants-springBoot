package com.jakuza.plants.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {

	UUID id;
	String title;
	String description;
	UUID invertory_item_location;
	double listing_price;
	String currency;
	int quantity;
	int listing_status;
	int marketplace;
	String upload_time;
	String owner_email_address;


	@Override
	public String toString() {
			return title + ": " + description;
	}
}
