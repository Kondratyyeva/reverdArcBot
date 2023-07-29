package com.example.squanchme.service;

import com.example.squanchme.updateHandler.UpdateHandlerService;
import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.squanchme.config.BotProperties;
import com.example.squanchme.updateHandler.StartCommandHandler;
import com.example.squanchme.updateHandler.WorkoutsHandler;

import lombok.Builder;

@Builder
public class RevengeArcBot extends TelegramLongPollingBot {
    private BotProperties botProperties;
    private StartCommandHandler startCommandHandler;
    private WorkoutsHandler workoutsHandler;
    private UpdateHandlerService updateHandlerService;

    public RevengeArcBot(BotProperties botProperties, StartCommandHandler startCommandHandler,
                         WorkoutsHandler workoutsHandler, UpdateHandlerService updateHandlerService){
        this.botProperties=botProperties;
        this.workoutsHandler=workoutsHandler;
        this.startCommandHandler=startCommandHandler;
        this.updateHandlerService=updateHandlerService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!StringUtils.isBlank(update.getMessage().getText())){
            try {
                execute(updateHandlerService.handleUpdate(update));
            } catch (TelegramApiException e) {

            }
        }
    }

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }


}
