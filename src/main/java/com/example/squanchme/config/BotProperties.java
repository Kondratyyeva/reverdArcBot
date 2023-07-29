package com.example.squanchme.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Екатерина
 */
@Configuration
@ConfigurationProperties(prefix = "bot")
@PropertySource("classpath:/bot.properties")
@Data
public class BotProperties {
    private String name;
    private String token;
}
