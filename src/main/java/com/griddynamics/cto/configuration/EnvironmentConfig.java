package com.griddynamics.cto.configuration;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${env}.properties"})
public interface EnvironmentConfig extends Config {
    @Key("url")
    String url();
}
