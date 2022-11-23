package com.egorovwa.task_manager.User.model;

import com.egorovwa.task_manager.User.skillss.Skill;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    private UUID uuid;
    @NotBlank
    private String surname;
    @NotBlank
    private String name;
    @ManyToOne
    private Position position;
    @ManyToMany
    private Collection<Skill> skills;
}
