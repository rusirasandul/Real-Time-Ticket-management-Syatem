package com.example.Realtimeticketsystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ConfigService {

    private static final String CONFIG_FILE_PATH = "config.json";

    private Configuration config;

    public ConfigService() {
        // Try loading configuration on service initialization
        loadConfiguration();
    }

    // Method to load configuration from a JSON file
    public void loadConfiguration() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.config = objectMapper.readValue(new File(CONFIG_FILE_PATH), Configuration.class);
        } catch (IOException e) {
            System.out.println("Error loading configuration. Using default values.");
            this.config = new Configuration();  // Fallback to default values
        }
    }

    // Method to save the current configuration to a JSON file
    public void saveConfiguration() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(CONFIG_FILE_PATH), this.config);
        } catch (IOException e) {
            System.out.println("Error saving configuration.");
        }
    }

    // Get the configuration object
    public Configuration getConfig() {
        return config;
    }

    // Set the configuration object
    public void setConfig(Configuration config) {
        this.config = config;
        saveConfiguration();  // Automatically save whenever config changes
    }
}
