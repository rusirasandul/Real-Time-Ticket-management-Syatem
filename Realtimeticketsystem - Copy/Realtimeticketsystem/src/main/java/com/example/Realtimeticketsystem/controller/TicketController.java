package com.example.Realtimeticketsystem.controller;

import com.example.Realtimeticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public String addTickets(@RequestParam int tickets, @RequestParam String vendorName) {
        ticketService.addTickets(tickets, vendorName);
        return "Added " + tickets + " tickets by vendor " + vendorName;
    }

    @GetMapping("/total")
    public int getTotalTickets() {
        return ticketService.getTotalTickets();
    }
}
