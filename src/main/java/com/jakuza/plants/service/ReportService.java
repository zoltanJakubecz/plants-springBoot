package com.jakuza.plants.service;

import java.util.List;

import com.jakuza.plants.model.Report;
import com.jakuza.plants.model.dto.ReportMonthlyDTO;

import org.springframework.stereotype.Service;


/**
 * Report
 */
@Service
public class ReportService {


    public void createReport(List<ReportMonthlyDTO> reportMonthly){

        Report reportClass = new Report();

        int totalCount = reportMonthly
                .stream()
                .reduce(0, (partialResult, item) -> partialResult + item.getCount(), Integer::sum);

        reportClass.setTotal_listing_count( totalCount );
//        System.out.println(reportMonthly.stream().reduce(0, (partialResult, item) -> partialResult + item.getCount(), Integer::sum));
        reportMonthly.forEach(item -> System.out.println(item.getName()));
    }
}
