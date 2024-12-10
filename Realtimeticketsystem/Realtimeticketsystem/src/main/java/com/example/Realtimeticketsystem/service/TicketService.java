package com.example.Realtimeticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TicketService {

    private final SimpMessagingTemplate messagingTemplate; // Injected via constructor
    private final TicketPool ticketPool = new TicketPool();
    private final AtomicInteger ticketCount = new AtomicInteger(0); // Atomic counter for thread-safety

    @Autowired
    public TicketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate; // Initialize SimpMessagingTemplate
    }

    // Method to add tickets
    public void addTickets(int count, String vendorName) {
        ticketPool.addTickets(count, vendorName);
        ticketCount.addAndGet(count); // Update ticketCount atomically
        messagingTemplate.convertAndSend("/topic/tickets", "Vendor " + vendorName + " added " + count + " tickets.");
    }

    // Method to buy a ticket
    public String buyTicket(String customerName) {
        String ticket = ticketPool.buyTicket(customerName); // Simulate ticket buying from TicketPool
        if (ticket != null) {
            ticketCount.decrementAndGet(); // Decrement ticket count when a ticket is sold
            messagingTemplate.convertAndSend("/topic/tickets", "Customer " + customerName + " bought ticket: " + ticket);
        } else {
            messagingTemplate.convertAndSend("/topic/tickets", "Customer " + customerName + " failed to buy a ticket.");
        }
        return ticket;
    }

    // Method to get the number of remaining tickets
    public int getRemainingTickets() {
        return ticketCount.get(); // Return the current ticket count
    }
}
