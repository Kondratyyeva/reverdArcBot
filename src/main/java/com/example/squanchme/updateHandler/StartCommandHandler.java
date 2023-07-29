package com.example.squanchme.updateHandler;

import com.example.squanchme.config.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommandHandler implements UpdateHandler {

    private String startMessage;

    public StartCommandHandler(MessageText messageText) {
        this.startMessage = messageText.getStart();
    }

    @Override
    public SendMessage handleUpdate(Update update) {
        return SendMessage.builder().chatId(update.getMessage().getChatId()).text(startMessage).build();
    }
}
