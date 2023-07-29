package com.example.squanchme.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.List;

/**
 * @author Екатерина
 */

@Entity
@Data
public class Exercise {
    @Id
    private Long id;
    @Nonnull
    private String name;
    @ManyToMany
    private List<Workout> workout;
    @OneToMany
    private List<Set> sets;
}
