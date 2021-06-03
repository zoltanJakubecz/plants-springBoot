package com.jakuza.plants.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location{

	private UUID id;
	private String manager_name;
	private String phone;
	private String address_primary;
	private String address_secondary;
	private String country;
	private String town;
	private String postal_code;

}
