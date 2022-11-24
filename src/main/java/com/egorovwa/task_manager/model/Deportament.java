package com.egorovwa.task_manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Deportament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @OneToOne
    private User director;
    @OneToMany
    Collection<Deportament> subordinateDepartments;
    @ManyToMany
    private Collection<User> staff;

}
