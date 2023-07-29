package com.example.squanchme.updateHandler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateHandler {
    public SendMessage handleUpdate(Update update);
}
