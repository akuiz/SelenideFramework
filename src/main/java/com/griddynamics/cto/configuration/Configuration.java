package com.griddynamics.cto.configuration;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    public static final Configuration INSTANCE = new Configuration();
    private EnvironmentConfig environmentConfig;

    private Configuration() {
        this.environmentConfig = ConfigFactory.create(EnvironmentConfig.class, System.getenv(), System.getProperties());
    }

    public EnvironmentConfig getEnvironmentConfig() {
        return environmentConfig;
    }
}
