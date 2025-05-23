package com.example.asyncexample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class ReportService {

    @Async
    public CompletableFuture<String> generateSalesReport(String month) throws InterruptedException {
        System.out.println("Generating sales report for " + month + " on thread: " + Thread.currentThread().getName());
        Thread.sleep(3000); // This will simulate the delay
        return CompletableFuture.completedFuture("Sales report for " + month + " is ready.");
    }

    @Async
    public CompletableFuture<String> generateInventoryReport() throws InterruptedException {
        System.out.println("Generating inventory report on thread: " + Thread.currentThread().getName());
        Thread.sleep(4000); // This will simulate the delay
        return CompletableFuture.completedFuture("Inventory report is ready.");
    }
}
