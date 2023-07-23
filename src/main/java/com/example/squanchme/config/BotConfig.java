package com.example.squanchme.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("properties")
public class BotConfig {
    @Value("${bot.name}")
    private final String botName;
    @Value("${bot.tocken}")
    private final String botTocken;


}
