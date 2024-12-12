package com.example.Realtimeticketsystem.dto;

public class TicketResponseDto {
    private String message;
    private int totalTickets;

    public TicketResponseDto(String message, int totalTickets) {
        this.message = message;
        this.totalTickets = totalTickets;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
}
