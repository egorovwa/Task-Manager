package com.egorovwa.task_manager.User.model;

import com.egorovwa.task_manager.User.skillss.Skill;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title;
    private String description;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Access access;
    @ManyToMany // TODO: 23.11.2022 may be not.
    private Collection<Skill> mustBeSkills;
}
