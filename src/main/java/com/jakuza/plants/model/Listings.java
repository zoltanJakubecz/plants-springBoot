package com.jakuza.plants.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.jakuza.plants.model.dto.ListingsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
	private LocalDate upload_time;
	private String owner_email_address;


	public static Listings fromDTO(ListingsDTO listingsDTO) {

		return Listings.builder()
			.id(UUID.fromString(listingsDTO.getId()))
			.title(listingsDTO.getTitle())
			.description(listingsDTO.getDescription())
			.location_id(UUID.fromString(listingsDTO.getLocation_id()))
			.listing_price(listingsDTO.getListing_price())
			.currency(listingsDTO.getCurrency())
			.quantity(listingsDTO.getQuantity())
			.listing_status(listingsDTO.getListing_status())
			.marketplace(listingsDTO.getMarketplace())
			.upload_time(convertToDate(listingsDTO.getUpload_time()))
			.owner_email_address(listingsDTO.getOwner_email_address())
			.build();

	}


	private static LocalDate convertToDate(String stringDate){
		if(stringDate == null) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		return LocalDate.parse(stringDate, formatter);
	}

}
