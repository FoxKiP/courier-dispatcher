package ru.nazarov.restservice.utils;

import ru.nazarov.restservice.model.Task;

import java.time.LocalDateTime;
import java.util.List;

public class TaskTestData {
    public final static Matcher<Task> MATCHER = new Matcher<>(Task.class);

    public final static long ORDER_ID = 888888;

    public final static Task TASK_1 = new Task(100000, 584673, LocalDateTime.parse("2020-11-15T10:30"), false);
    public final static Task TASK_2 = new Task(100001, 476293, LocalDateTime.parse("2020-11-14T14:18"), false);
    public final static Task TASK_3 = new Task(100002, 9283, LocalDateTime.parse("2020-11-13T16:23"), false);

    public static Task getNew(Task task) {
        return new Task(task);
    }

    public static List<Task> getTasks() {
        return List.of(TASK_3, TASK_2, TASK_1);
    }
}
