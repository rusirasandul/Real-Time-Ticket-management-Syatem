package com.example.Realtimeticketsystem.service;

public class Custermer implements Runnable {
    private final String name;
    private final TicketService ticketService;
    private final int ticketsToBuy;

    // Updated constructor to include ticketsToBuy
    public Custermer(String name, TicketService ticketService, int ticketsToBuy) {
        this.name = name;
        this.ticketService = ticketService;
        this.ticketsToBuy = ticketsToBuy;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketsToBuy; i++) {
            String ticketInfo = ticketService.buyTicket(name);
            if (ticketInfo == null) {
                System.out.println(name + " tried to buy a ticket, but none were available.");
                break;
            } else {
                System.out.println(name + " successfully bought a ticket: " + ticketInfo);
            }
        }
    }
}
