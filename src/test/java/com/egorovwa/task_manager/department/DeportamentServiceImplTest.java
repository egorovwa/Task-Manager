package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.User.UserService;
import com.egorovwa.task_manager.User.position.PositionService;
import com.egorovwa.task_manager.exceptions.DeportamentNotFoundException;
import com.egorovwa.task_manager.model.Access;
import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeportamentServiceImplTest {
    @Mock
    DeportamentRepository deportamentRepository;
    @Mock
    UserService userService;
    @Mock
    PositionService positionService;
    @InjectMocks
    DeportamentServiceImpl deportamentService;

    Position position =  new Position(1L, "position",
            "sss",
            Access.GENERAL,
            List.of(),
            false);
    User director = new User(1L,"f", "name", "0000", position, List.of(),List.of(),null);



    @Test
    void test1_findById() throws DeportamentNotFoundException {
        Deportament deportament = new Deportament(
                1L,
                "deport",
                position,
                director,
                List.of(),
                List.of()
        );
        when(deportamentRepository.findById(1L))
                .thenReturn(Optional.of(deportament));
        deportamentService.findById(1L, UUID.randomUUID());
        verify(deportamentRepository, times(1)).findById(1L);
    }
    @Test
    void test1_1_findById_whenDeportamentNotFound() throws DeportamentNotFoundException {
                when(deportamentRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(DeportamentNotFoundException.class, ()->{
        deportamentService.findById(1L, UUID.randomUUID());});

    }

    @Test
    void createDepotrament() {
    }

    @Test
    void addStaf() {
    }

    @Test
    void chengeDirector() {
    }

    @Test
    void findByIdOptional() {
    }
}