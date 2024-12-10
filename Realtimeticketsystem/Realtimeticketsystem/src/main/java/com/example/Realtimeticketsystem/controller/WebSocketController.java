package com.example.Realtimeticketsystem.controller;

import com.example.Realtimeticketsystem.service.TicketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// Define request DTOs for adding and buying tickets
class TicketRequest {
    private int count;
    private String vendorName;

    // Getters and setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}

class CustomerRequest {
    private String customerName;

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

@Controller
public class WebSocketController {

    private final TicketService ticketService;

    public WebSocketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @MessageMapping("/addTicket") // Client sends message here
    @SendTo("/topic/tickets")     // Message is broadcast to this topic
    public String addTicket(TicketRequest ticketRequest) {
        ticketService.addTickets(ticketRequest.getCount(), ticketRequest.getVendorName());
        return "New tickets added by " + ticketRequest.getVendorName();
    }

    @MessageMapping("/buyTicket")
    @SendTo("/topic/tickets")
    public String buyTicket(CustomerRequest customerRequest) {
        String ticketInfo = ticketService.buyTicket(customerRequest.getCustomerName());
        return ticketInfo != null
                ? "Ticket purchased by " + customerRequest.getCustomerName()
                : "No tickets available for " + customerRequest.getCustomerName();
    }
}
