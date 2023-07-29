package com.example.squanchme.config;

import com.example.squanchme.updateHandler.UpdateHandlerService;
import com.example.squanchme.service.user.UserService;
import com.example.squanchme.service.user.WorkoutService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.squanchme.service.RevengeArcBot;
import com.example.squanchme.updateHandler.StartCommandHandler;
import com.example.squanchme.updateHandler.WorkoutsHandler;


@Configuration
public class BotConfiguration {

    @Bean
    public StartCommandHandler startCommandHandler(MessageText messageText){
        return  new StartCommandHandler(messageText);
    }

    @Bean
    public WorkoutsHandler workoutsListHandler(MessageText messageText, WorkoutService workoutService,
                                               UserService userService){
        return new WorkoutsHandler(messageText, workoutService, userService);
    }

    @Bean
    public UpdateHandlerService updateHandlerService(StartCommandHandler startCommandHandler,
                                                     WorkoutsHandler workoutsListHandler){
        return new UpdateHandlerService(startCommandHandler, workoutsListHandler);
    }

    @Bean
    public RevengeArcBot revengeArcBot(BotProperties botProperties, StartCommandHandler startCommandHandler,
                                       WorkoutsHandler workoutsHandler, UpdateHandlerService updateHandlerService) throws TelegramApiException{
        RevengeArcBot revengeArcBot = new RevengeArcBot(botProperties, startCommandHandler,
                workoutsHandler, updateHandlerService);
        new TelegramBotsApi(DefaultBotSession.class).registerBot(revengeArcBot);
        return  revengeArcBot;
    }

}
