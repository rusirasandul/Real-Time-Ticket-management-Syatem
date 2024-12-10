package com.example.Realtimeticketsystem.service;

public class Custermer implements Runnable {
    private final String name;
    private final TicketService ticketService;
    private final int ticketsToBuy;

    public Custermer(String name, TicketService ticketService, int ticketsToBuy) {
        this.name = name;
        this.ticketService = ticketService;
        this.ticketsToBuy = ticketsToBuy;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketsToBuy; i++) {
            try {
                String ticket = ticketService.buyTicket(name);
                System.out.println(name + " successfully purchased: " + ticket);
            } catch (RuntimeException e) {
                System.err.println(name + " failed to buy a ticket: " + e.getMessage());
            }
        }
    }
}
