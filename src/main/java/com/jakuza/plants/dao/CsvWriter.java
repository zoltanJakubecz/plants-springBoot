package com.jakuza.plants.dao;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

/**
* CsvWriter
*/
@Component
public class CsvWriter {
	
	public void saveToFile(List<String[]> dataLines) {

  	  File csvOutFile = new File("importLog.csv");

			try(PrintWriter pw = new PrintWriter(csvOutFile)) {
				pw.println("ListingsId;MarketPlaceName;InvalidFied");
				dataLines.stream()
					.map(this::convertToCSV)
					.forEach(pw::println);
				
			} catch (Exception e) {
				System.out.println(e);
			}
	}

	public String convertToCSV(String[] data) {
  	  return Stream.of(data)
      	.collect(Collectors.joining(";"));
	}

}
