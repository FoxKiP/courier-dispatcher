package ru.nazarov.restservice.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nazarov.restservice.model.Task;
import ru.nazarov.restservice.repository.TaskRepository;
import ru.nazarov.restservice.util.ValidationUtil;

@RestController
@RequestMapping("/courier/task")
public class CourierController {

    private final TaskRepository repository;

    public CourierController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    void create(@RequestParam String orderId) {
        ValidationUtil.validOrderId(orderId);
        repository.save(new Task(Long.parseLong(orderId)));
    }
}
