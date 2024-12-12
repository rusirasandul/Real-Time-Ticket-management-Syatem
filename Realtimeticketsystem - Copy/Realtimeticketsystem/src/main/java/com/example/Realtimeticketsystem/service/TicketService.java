package com.example.Realtimeticketsystem.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TicketService {
    private int totalTickets = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void addTickets(int tickets, String vendorName) {
        lock.lock();
        try {
            totalTickets += tickets;
            System.out.println("Vendor " + vendorName + " added " + tickets + " tickets. Total tickets: " + totalTickets);
        } finally {
            lock.unlock();
        }
    }
    public String buyTicket(String customerName) {
        lock.lock();
        try {
            if (totalTickets > 0) {
                totalTickets--;
                return "Ticket purchased successfully";
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }


    public int getTotalTickets() {
        return totalTickets;
    }
}
