package com.example.Realtimeticketsystem.dto;

public class TicketResponseDto {
    private Long id;
    private String eventName;
    private boolean sold;

    public TicketResponseDto(Long id, String eventName, boolean sold) {
        this.id = id;
        this.eventName = eventName;
        this.sold = sold;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public boolean isSold() {
        return sold;
    }
}
