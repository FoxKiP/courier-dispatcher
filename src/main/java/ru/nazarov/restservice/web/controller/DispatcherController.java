package ru.nazarov.restservice.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.nazarov.restservice.exception.NotFoundException;
import ru.nazarov.restservice.model.Task;
import ru.nazarov.restservice.repository.TaskRepository;
import ru.nazarov.restservice.util.ValidationUtil;

import java.util.List;

@RestController
@RequestMapping("/dispatcher/task")
public class DispatcherController {

    private final TaskRepository repository;

    public DispatcherController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Task> getAll() {
        return repository.findAll();
    }

    @GetMapping("/search")
    Task getByOrderId(@RequestParam String orderId) {
        ValidationUtil.validOrderId(orderId);
        return repository.findByOrderId(Long.parseLong(orderId)).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/completed/{id}")
    void completed(@PathVariable("id") long taskId) {
        repository.completed(taskId);
    }

    @DeleteMapping("/delete/{id}")
    void deleteIfCompleted (@PathVariable("id") long taskId) {
        repository.deleteIfCompleted(taskId);
    }
}
