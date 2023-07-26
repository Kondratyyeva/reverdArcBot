package com.example.squanchme.model;

import lombok.Data;

import java.util.List;

@Data
public class Workout {
    private Integer id;
    private List<Exercise> exercises;
}
