package com.egorovwa.task_manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Deportament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotNull
    @OneToOne
    private Position directorPosition;
    @NotNull
    @OneToOne
    private User director;
    @OneToMany
    Collection<Deportament> subordinateDepartments;
    @OneToMany
    private Collection<User> staff;

    public Deportament(String name, Position directorPosition, User director) {
        this.name = name;
        this.directorPosition = directorPosition;
        this.director = director;
    }
}
