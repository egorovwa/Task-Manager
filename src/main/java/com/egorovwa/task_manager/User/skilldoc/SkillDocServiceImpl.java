package com.egorovwa.task_manager.User.skilldoc;

import com.egorovwa.task_manager.exceptions.SkillDocAlredyExist;
import com.egorovwa.task_manager.model.SkillDoc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Slf4j
public class SkillDocServiceImpl implements SkillDocService {
    private final SkillDocRepository repository;
    @Override
    public SkillDoc addSkilDoc(UUID maderId, SkillDoc skillDoc) throws SkillDocAlredyExist {
        log.debug("User id = {} add SkillDoc {}", maderId, skillDoc);
        if (repository.findByResLink(skillDoc.getResLink()).isPresent()){
            throw new SkillDocAlredyExist("reslink", skillDoc.getResLink());
        }
        return repository.save(skillDoc);
    }
}
