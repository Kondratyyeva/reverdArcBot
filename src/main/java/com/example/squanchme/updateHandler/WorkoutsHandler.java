package com.example.squanchme.updateHandler;

import com.example.squanchme.config.MessageText;
import com.example.squanchme.model.User;
import com.example.squanchme.model.Workout;
import com.example.squanchme.service.user.UserService;
import com.example.squanchme.service.user.WorkoutService;
import lombok.val;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class WorkoutsHandler implements UpdateHandler {
    private WorkoutService workoutService;
    private UserService userService;

    private String noWorkoutsText;

    public WorkoutsHandler(MessageText messageText, WorkoutService workoutService,
                            UserService userService){
        this.noWorkoutsText = messageText.getNoWorkouts();
        this.userService=userService;
        this.workoutService=workoutService;
    }
    @Override
    public SendMessage handleUpdate(Update update) {
        val chatId = update.getMessage().getChatId();
        if(userService.findByChatId(chatId).isEmpty()){
            return SendMessage.builder().chatId(chatId).text(noWorkoutsText).build();
        } else{
            User user = userService.findByChatId(chatId).get();
            List<Workout> workouts = workoutService.getWorkoutsByUser(user);
            if (workouts.isEmpty()){
                return SendMessage.builder().chatId(chatId).text(noWorkoutsText).build();
            }else{
                return SendMessage.builder().chatId(chatId).text(String.valueOf(workouts)).build();
            }
        }
    }
}
