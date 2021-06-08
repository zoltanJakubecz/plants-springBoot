package com.jakuza.plants.dao;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

/**
* CsvWriter
*/
@Component
public class CsvWriter {
	
	public static void saveToFile(String[] data) {
  	  File csvOutFile = new File("test.csv");
	}
}
