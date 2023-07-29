package com.example.squanchme.repo;

import com.example.squanchme.model.User;
import org.springframework.data.repository.CrudRepository;

import com.example.squanchme.model.Workout;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepo extends CrudRepository<Workout, Long> {
    public List<Workout> getWorkoutsByUser(User user);
}
