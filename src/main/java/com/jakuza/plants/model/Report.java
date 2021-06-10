package com.jakuza.plants.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Report
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
	
	private int total_listing_count;
	private int total_ebay_count;
	private double total_ebay_price;
	private double average_ebay_listing_price;
	private int total_amazon_count;
	private double total_amazon_price;
	private double average_amazon_listing_price;
	private String best_lister;
	private List<String> ebay_count;
	private List<String> amazon_count;
	private List<String> ebay_price;
	private List<String> amazon_price;
	private List<String> ebay_average;
	private List<String> amazon_average;
	private List<String> monthly_best_lister;

}
