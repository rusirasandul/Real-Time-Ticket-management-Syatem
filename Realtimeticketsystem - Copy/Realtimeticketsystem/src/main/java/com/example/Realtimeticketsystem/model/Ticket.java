package com.example.Realtimeticketsystem.model;

public class Ticket {
    private final String id;
    private final String vendorName;

    public Ticket(String id, String vendorName) {
        this.id = id;
        this.vendorName = vendorName;
    }

    public String getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}
