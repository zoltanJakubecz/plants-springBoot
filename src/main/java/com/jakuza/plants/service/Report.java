package com.jakuza.plants.service;

import java.util.List;

import com.jakuza.plants.model.dto.ReportFullDTO;

import org.springframework.stereotype.Service;


/**
 * Report
 */
@Service
public class Report {


    public void createReport(List<ReportFullDTO> report){

        report.forEach(item -> System.out.println(item.getName()));
    }
}
