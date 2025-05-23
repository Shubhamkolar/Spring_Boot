package com.example.asyncexample.controller;

import com.example.asyncexample.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public CompletableFuture<String> getSalesReport(@RequestParam String month) throws InterruptedException {
        return reportService.generateSalesReport(month);
    }

    @GetMapping("/inventory")
    public CompletableFuture<String> getInventoryReport() throws InterruptedException {
        return reportService.generateInventoryReport();
    }
}
