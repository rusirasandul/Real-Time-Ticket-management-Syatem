package com.example.Realtimeticketsystem.service;

public class Vendor implements Runnable {
    private final String name;
    private final TicketService ticketService;
    private final int ticketsToAdd;

    public Vendor(String name, TicketService ticketService, int ticketsToAdd) {
        this.name = name;
        this.ticketService = ticketService;
        this.ticketsToAdd = ticketsToAdd;
    }

    @Override
    public void run() {
        ticketService.addTickets(ticketsToAdd, name);
    }
}
