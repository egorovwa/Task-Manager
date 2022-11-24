package com.egorovwa.task_manager.dto.deportament;

import com.egorovwa.task_manager.dto.user.UserShortDto;
import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeportamentFulldto {
    private Long id;
    private String name;
    private UserShortDto director;
    @OneToMany
    Collection<Deportament> subordinateDepartments;
    @ManyToMany
    private Collection<User> staff;
}
