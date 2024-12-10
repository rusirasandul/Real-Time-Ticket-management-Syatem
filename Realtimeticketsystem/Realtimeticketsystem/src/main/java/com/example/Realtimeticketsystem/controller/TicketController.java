package com.example.Realtimeticketsystem.controller;

import com.example.Realtimeticketsystem.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Vendor adds tickets
    @PostMapping("/add")
    public String addTickets(@RequestParam int count, @RequestParam String vendorName) {
        ticketService.addTickets(count, vendorName);
        return count + " tickets added to the pool by vendor: " + vendorName;
    }

    // Customer buys a ticket
    @GetMapping("/buy")
    public String buyTicket(@RequestParam String customerName) {
        String ticket = ticketService.buyTicket(customerName);
        return customerName + " successfully bought ticket: " + ticket;
    }

    // Get remaining ticket count
    @GetMapping("/remaining")
    public int getRemainingTickets() {
        return ticketService.getRemainingTickets();
    }
}
