package com.example.squanchme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Data
public class Workout {
    @Id
    private Long id;
    @ManyToMany
    private List<Exercise> exercises;
    @ManyToOne
    private User user;
}
