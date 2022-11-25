package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.Constats;
import com.egorovwa.task_manager.User.UserService;
import com.egorovwa.task_manager.User.position.PositionService;
import com.egorovwa.task_manager.dto.deportament.DeportamenCreateDto;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import com.egorovwa.task_manager.exceptions.*;
import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeportamentServiceImpl implements DeportamentService {
    private final DeportamentRepository deportamentRepository;
    private final UserService userService;
    private final PositionService positionService;

    @Override
    public DeportamentFulldto findById(Long id, UUID maderId) throws DeportamentNotFoundException {
        log.debug("User id = {}. Find Deportament id = {}", maderId, id);
        return DeportamentDtoMaper.toFullDto(deportamentRepository.findById(id)
                .orElseThrow(() -> new DeportamentNotFoundException("id", id.toString())));
    }

    @Override
    public DeportamentFulldto createDepotrament(UUID maderId, DeportamenCreateDto createDto) throws PositionNotFoundException, UserNotFoundException, AlreadyExists, UserNotFreeException, PositionNotValidException {
        Position directorPosition = positionService.findById(createDto.getDirectorPositionId())
                .orElseThrow(() -> new PositionNotFoundException("id", createDto.getDirectorPositionId().toString()));  // TODO: 25.11.2022 Android creatr position fragmen -> create deportament fragment
        if (!directorPosition.getIsMustPresent()) {
            throw new PositionNotValidException("Position name = {} value isMustPresent must be true ", directorPosition);
        }
        User director = userService.findByIdOptional(createDto.getDirectorId())
                .orElseThrow(() -> new UserNotFoundException("id", createDto.getDirectorId().toString()));
        if (director.getPosition().equals(Constats.FREE)) {
            director.setPosition(directorPosition);
            userService.updateUser(director);
        } else {
            throw new UserNotFreeException("User not free", director.getUuid());
        }
        try {
            log.info("User id = {}. Create Deportament name = {}", maderId, createDto.getName());
            return DeportamentDtoMaper.toFullDto(deportamentRepository.save(
                    new Deportament(
                            createDto.getName(),
                            directorPosition,
                            director
                    )
            ));
        } catch (DataIntegrityViolationException e) {
            log.warn("User id = {}. An attempt to create a deportament called {} ", maderId, createDto.getName());
            throw new AlreadyExists("Deportament allredy exist", "Deportament", "name", createDto.getName());
        }
    }

    @Override
    @Transactional
    public void addStaf(UUID maderId, Long deportamentId, UUID userId) throws DeportamentNotFoundException, UserNotFoundException, NoActionRequired {
        Deportament deportament = deportamentRepository.findById(deportamentId)
                .orElseThrow(() -> new DeportamentNotFoundException("id", deportamentId.toString()));
        User user = userService.findByIdOptional(userId)
                .orElseThrow(() -> new UserNotFoundException("id", userId.toString()));
        if (deportament.getStaff().contains(user)){
            throw new NoActionRequired(String.format("User id= %s alredy in deportament id = %s",userId, deportamentId));
        }
        Deportament oldDeportament = user.getDeportaments();
        oldDeportament.getStaff().remove(user);
        deportamentRepository.save(oldDeportament);
        deportament.getStaff().add(user);
        deportamentRepository.save(deportament);
        user.setDeportaments(deportament);
        userService.updateUser(user);

    }

    @Override
    public void chengeDirector(UUID maderId, Long deportamentId, UUID userId) {

    }

    @Override
    public Optional<Deportament> findByIdOptional(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Deportament> findByDirectorPosition(Position position) {
        return deportamentRepository.findByDirectorPosition(position);
    }

    @Override
    public void updateDeportament(Deportament r) {

    }
}
