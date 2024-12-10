package com.example.Realtimeticketsystem.service;

public class Configuration {

    private int ticketLimit;   // Maximum number of tickets
    private String serverName; // Server name or environment name

    // Default constructor with default values
    public Configuration() {
        this.ticketLimit = 100;    // Default ticket limit
        this.serverName = "DefaultServer";  // Default server name
    }

    // Getters and Setters
    public int getTicketLimit() {
        return ticketLimit;
    }

    public void setTicketLimit(int ticketLimit) {
        this.ticketLimit = ticketLimit;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "ticketLimit=" + ticketLimit +
                ", serverName='" + serverName + '\'' +
                '}';
    }
}
