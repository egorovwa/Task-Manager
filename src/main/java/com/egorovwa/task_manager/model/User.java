package com.egorovwa.task_manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
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
    @ManyToOne
    private Deportament deportaments;

}
