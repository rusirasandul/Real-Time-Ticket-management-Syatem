package com.example.Realtimeticketsystem.controller;

import com.example.Realtimeticketsystem.service.TicketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


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

    /**
     * Handles the addition of tickets by vendors.
     * @param ticketRequest Contains the number of tickets and vendor name.
     * @return A message to be broadcasted to all subscribers about the updated ticket status.
     */
    @MessageMapping("/addTicket") // Client sends messages to this endpoint
    @SendTo("/topic/tickets")     // Broadcast messages to this topic
    public String addTicket(TicketRequest ticketRequest) {
        try {
            ticketService.addTickets(ticketRequest.getCount(), ticketRequest.getVendorName());
            return "New tickets added by " + ticketRequest.getVendorName() + ". Total tickets: " + ticketService.getTotalTickets();
        } catch (Exception e) {
            return "Error while adding tickets: " + e.getMessage();
        }
    }

    /**
     * Handles the purchase of tickets by customers.
     * @param customerRequest Contains the customer name requesting a ticket.
     * @return A message to be broadcasted to all subscribers about the purchase status.
     */
    @MessageMapping("/buyTicket") // Client sends messages to this endpoint
    @SendTo("/topic/tickets")     // Broadcast messages to this topic
    public String buyTicket(CustomerRequest customerRequest) {
        try {
            String ticketInfo = ticketService.buyTicket(customerRequest.getCustomerName());
            return ticketInfo != null
                    ? ticketInfo + " by " + customerRequest.getCustomerName() + ". Remaining tickets: " + ticketService.getTotalTickets()
                    : "No tickets available for " + customerRequest.getCustomerName();
        } catch (Exception e) {
            return "Error while processing ticket purchase: " + e.getMessage();
        }
    }
}
