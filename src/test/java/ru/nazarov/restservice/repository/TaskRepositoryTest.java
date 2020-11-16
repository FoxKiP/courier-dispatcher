package ru.nazarov.restservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nazarov.restservice.base.AbstractTest;
import ru.nazarov.restservice.model.Task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static ru.nazarov.restservice.utils.TaskTestData.*;


class TaskRepositoryTest extends AbstractTest {

    @Autowired
    TaskRepository repository;

    @Test
    void findByOrderId() {
        assertThat(repository.findByOrderId(TASK_3.getOrderId()).get()).isEqualTo(TASK_3);
    }

    @Test
    void save() {
        repository.save(new Task(ORDER_ID));
        assertFalse(repository.findByOrderId(ORDER_ID).isEmpty());
    }

    @Test
    void findAll() {
        assertThat(repository.findAll()).isEqualTo(getTasks());
    }


    @Test
    void completed() {
        Task expected = getNew(TASK_3);
        expected.setCompleted(true);
        repository.completed(TASK_3.getId());
        assertThat(repository.findByOrderId(TASK_3.getOrderId()).get()).isEqualTo(expected);
    }

    @Test
    void deleteIfCompleted() {
        repository.completed(TASK_3.getId());
        repository.deleteIfCompleted(TASK_3.getId());
        assertTrue(repository.findByOrderId(TASK_3.getOrderId()).isEmpty());
    }
}