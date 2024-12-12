package com.example.Realtimeticketsystem;

import com.example.Realtimeticketsystem.service.Custermer;
import com.example.Realtimeticketsystem.service.TicketService;
import com.example.Realtimeticketsystem.service.Vendor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class RealtimeticketsystemApplication {

	public static void main(String[] args) {
		// Start the Spring application and get the application context
		ApplicationContext context = SpringApplication.run(RealtimeticketsystemApplication.class, args);

		// Retrieve the TicketService bean from the Spring context
		TicketService ticketService = context.getBean(TicketService.class);

		// Use Scanner to accept vendor details from the user
		Scanner scanner = new Scanner(System.in);

		// Create a list to keep track of vendor threads
		List<Thread> vendorThreads = new ArrayList<>();

		// Loop to add multiple vendors
		while (true) {
			System.out.println("Enter Vendor Name (or type 'exit' to stop adding vendors):");
			String vendorName = scanner.nextLine();

			if ("exit".equalsIgnoreCase(vendorName)) {
				break; // Exit the loop if the user types "exit"
			}

			System.out.println("Enter Number of Tickets to Add:");
			int ticketCount = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			// Create and start the vendor thread
			Vendor vendor = new Vendor(vendorName, ticketService, ticketCount);
			Thread vendorThread = new Thread(vendor);
			vendorThreads.add(vendorThread);
			vendorThread.start();
		}

		// Create customers
		Custermer customer1 = new Custermer("Customer1", ticketService, 30);
		Custermer customer2 = new Custermer("Customer2", ticketService, 50);
		Custermer customer3 = new Custermer("Customer3", ticketService, 40);
		Custermer customer4 = new Custermer("Customer4" , ticketService , 10);
		Custermer customer5 = new Custermer("Customer5" , ticketService , 3);

		// Simulate ticket buying with threads
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(customer1);
		executorService.submit(customer2);
		executorService.submit(customer3);
		executorService.submit(customer4);
		executorService.submit(customer5);

		// Allow stopping the system
		System.out.println("Type 'stop' to terminate the system:");
		while (true) {
			String command = scanner.nextLine();
			if ("stop".equalsIgnoreCase(command)) {
				System.out.println("Shutting down the system...");
				executorService.shutdownNow();
				for (Thread vendorThread : vendorThreads) {
					vendorThread.interrupt();
				}
				break;
			}
		}

		// Cleanup resources
		scanner.close();
	}
}
