package com.example.Realtimeticketsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.Realtimeticketsystem.service.TicketPool;

@Configuration
public class TicketSystemConfig {

    /**
     * Bean for TicketPool to allow dependency injection across the system.
     */
    @Bean
    public TicketPool ticketPool() {
        return new TicketPool();
    }





    // You can add more beans here for configuration as needed
}
