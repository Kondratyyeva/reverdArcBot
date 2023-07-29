package com.example.squanchme.service.user;

import com.example.squanchme.model.User;
import com.example.squanchme.model.Workout;
import com.example.squanchme.repo.WorkoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Екатерина
 */
@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepo workoutRepo;

    public List<Workout> getWorkoutsByUser(User user){
        return workoutRepo.getWorkoutsByUser(user);
    }

}
