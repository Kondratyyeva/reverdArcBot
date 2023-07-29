package com.example.squanchme.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Екатерина
 */
@Configuration
@ConfigurationProperties(prefix = "message")
@PropertySource("classpath:/message.properties")
@Data
public class MessageText {
    private String start;
    private String noWorkouts;
}
