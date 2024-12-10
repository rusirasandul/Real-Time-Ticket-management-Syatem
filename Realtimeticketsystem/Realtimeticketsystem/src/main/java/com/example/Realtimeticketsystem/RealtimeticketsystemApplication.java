package com.example.Realtimeticketsystem;

import com.example.Realtimeticketsystem.service.Custermer;
import com.example.Realtimeticketsystem.service.TicketService;
import com.example.Realtimeticketsystem.service.Vendor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication

@ComponentScan(basePackages = "com.example.Realtimeticketsystem")
public class RealtimeticketsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeticketsystemApplication.class, args);

		// Initialize the TicketService
		TicketService ticketService = new TicketService();

		// Create a vendor and add tickets
		Vendor vendor = new Vendor("Vendor1", ticketService, 100);
		new Thread(vendor).start();

		// Create customers
		Custermer customer1 = new Custermer("Customer1", ticketService, 30);
		Custermer customer2 = new Custermer("Customer2", ticketService, 50);
		Custermer customer3 = new Custermer("Customer3", ticketService, 40);

		// Simulate ticket buying with threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(customer1);
		executorService.submit(customer2);
		executorService.submit(customer3);

		// Shutdown the executor
		executorService.shutdown();
	}
}
