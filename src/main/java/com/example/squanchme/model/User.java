package com.example.squanchme.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

/**
 * @author Екатерина
 */
@Entity
@Data
public class User {
    @Id
    private Long id;
    @Nonnull
    private Long chatId;
    @OneToMany
    private List<Workout> workouts;
}
