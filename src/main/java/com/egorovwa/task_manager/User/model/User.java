package com.egorovwa.task_manager.User.model;

import com.egorovwa.task_manager.User.skillss.Skill;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    @Column(unique = true)
    private String identificationСard;      // TODO: 24.11.2022 добавить влидатор номера
    @ManyToOne
    @NotNull
    private Position position;
    @ManyToMany
    private Collection<Skill> skills;
    @OneToMany
    private Collection<SkillDoc> documentSkil;
}
