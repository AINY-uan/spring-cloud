package org.ainy.db.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class PushEngineDataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}