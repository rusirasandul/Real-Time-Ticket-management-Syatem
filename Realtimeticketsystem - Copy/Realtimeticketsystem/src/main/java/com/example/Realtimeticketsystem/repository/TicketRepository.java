package com.example.Realtimeticketsystem.repository;

import com.example.Realtimeticketsystem.model.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketRepository {
    private final List<Ticket> tickets = Collections.synchronizedList(new ArrayList<>());

    // Add a new ticket
    public void saveTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Retrieve all tickets
    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    // Find a ticket by its ID
    public Ticket findById(String ticketId) {
        synchronized (tickets) {
            return tickets.stream()
                    .filter(ticket -> ticket.getId().equals(ticketId))
                    .findFirst()
                    .orElse(null);
        }
    }

    // Remove a ticket by its ID
    public boolean deleteById(String ticketId) {
        synchronized (tickets) {
            return tickets.removeIf(ticket -> ticket.getId().equals(ticketId));
        }
    }
}
