package com.example.squanchme.service;

import com.example.squanchme.config.BotConfig;
import com.example.squanchme.service.commands.CommandMessageHandler;
import com.example.squanchme.service.commands.StartMessageHandler;
import com.example.squanchme.service.commands.TrainMessageHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

import static java.util.Map.entry;

@Component
public class RevengeArcBot extends TelegramLongPollingBot {


    private static final Map<String, CommandMessageHandler> commandMessageHandlers = Map.ofEntries(
            entry("/start", new StartMessageHandler()),
            entry("/revengePlan", new TrainMessageHandler())
    );

    private final BotConfig botConfig;

    public RevengeArcBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!StringUtils.isBlank(update.getMessage().getText())){
             commandMessageHandlers.get(update.getMessage().getText()).handleMessage();
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }


}
