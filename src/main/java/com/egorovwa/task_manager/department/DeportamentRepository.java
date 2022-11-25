package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeportamentRepository extends JpaRepository<Deportament, Long> {
    Optional<Deportament> findByDirectorPosition(Position position);
}
