package com.example.Realtimeticketsystem.repository;

import java.util.HashMap;
import java.util.Map;

public class ConfigRepository {
    private final Map<String, String> config = new HashMap<>();

    // Save a configuration
    public void saveConfig(String key, String value) {
        config.put(key, value);
    }

    // Retrieve a configuration by its key
    public String getConfig(String key) {
        return config.get(key);
    }

    // Retrieve all configurations
    public Map<String, String> findAllConfigs() {
        return new HashMap<>(config);
    }

    // Delete a configuration by its key
    public void deleteConfig(String key) {
        config.remove(key);
    }
}
