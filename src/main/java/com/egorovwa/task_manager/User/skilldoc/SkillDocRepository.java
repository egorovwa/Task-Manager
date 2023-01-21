package com.egorovwa.task_manager.User.skilldoc;

import com.egorovwa.task_manager.model.SkillDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillDocRepository extends JpaRepository<SkillDoc, String> {
    Optional<SkillDoc> findByResLink(String resLink);

}