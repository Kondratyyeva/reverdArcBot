package com.example.squanchme.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

/**
 * @author Екатерина
 */
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Set {
    @Id
    private Long id;
    @Nonnull
    @ManyToOne
    private Exercise exercise;
    private Double weight;
    private Long repetitionsCount;

}
