package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.User.model.Position;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
