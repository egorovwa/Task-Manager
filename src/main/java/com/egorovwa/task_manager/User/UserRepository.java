package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
