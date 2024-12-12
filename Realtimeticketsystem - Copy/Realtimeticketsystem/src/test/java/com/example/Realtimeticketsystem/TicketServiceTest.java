package com.example.Realtimeticketsystem;

import com.example.Realtimeticketsystem.service.TicketService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketServiceTest {
    private final TicketService ticketService = new TicketService();

    @Test
    void testConcurrentTicketPurchases() {
        // Vendor adds 10 tickets
        ticketService.addTickets(10, "Vendor1");

        // Create a thread pool to simulate multiple customers
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Simulate 15 customers trying to buy tickets
        for (int i = 1; i <= 15; i++) {
            String customerName = "Customer" + i;
            executor.submit(() -> {
                try {
                    String ticket = ticketService.buyTicket(customerName);
                    System.out.println(customerName + " successfully purchased: " + ticket);
                } catch (RuntimeException e) {
                    System.err.println(customerName + " failed to buy ticket: " + e.getMessage());
                }
            });
        }

        // Shutdown the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to complete
        }

        // Verify remaining tickets (optional assertion for test purposes)
        System.out.println("Remaining tickets: " + ticketService.getRemainingTickets());
    }
}
