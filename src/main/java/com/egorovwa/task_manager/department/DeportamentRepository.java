package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.model.Deportament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportamentRepository extends JpaRepository<Deportament, Long> {
}
