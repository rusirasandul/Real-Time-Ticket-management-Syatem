package com.example.Realtimeticketsystem.service;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<String> tickets = new LinkedList<>();

    // Synchronized method to add tickets to the pool
    public synchronized void addTickets(int count, String vendorName) {
        for (int i = 0; i < count; i++) {
            tickets.add("Ticket-" + (tickets.size() + 1) + " (Vendor: " + vendorName + ")");
        }
        System.out.println(count + " tickets added by vendor: " + vendorName);
        notifyAll(); // Notify waiting threads that tickets are available
    }

    // Synchronized method to buy a ticket from the pool
    public synchronized String buyTicket(String customerName) {
        while (tickets.isEmpty()) {
            try {
                System.out.println(customerName + " is waiting for tickets...");
                wait(); // Wait until tickets are available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted", e);
            }
        }
        String ticket = tickets.poll();
        System.out.println(customerName + " bought " + ticket);
        return ticket;
    }
}
