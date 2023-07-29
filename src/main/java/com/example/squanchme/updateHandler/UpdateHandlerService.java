package com.example.squanchme.updateHandler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

/**
 * @author Екатерина
 */
public class UpdateHandlerService {
    private Map<String, UpdateHandler> updateHandlers;

    public UpdateHandlerService(StartCommandHandler startCommandHandler, WorkoutsHandler workoutsHandler){
        updateHandlers = Map.of(
                "/start", startCommandHandler,
                "/workouts", workoutsHandler);
    }

    public SendMessage handleUpdate(Update update){
        return updateHandlers.get(update.getMessage().getText()).handleUpdate(update);
    }
}
