package com.egorovwa.task_manager.User.skillss;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Page<Skill> findAll(Integer from, Integer size);
}
