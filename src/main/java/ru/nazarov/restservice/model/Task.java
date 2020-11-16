package ru.nazarov.restservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;


public class Task {

    private long id;
    private long orderId;
    private LocalDateTime registered;
    private boolean completed;

    public Task(long orderId) {
        this.orderId = orderId;
        this.registered = LocalDateTime.now();
    }

    @JsonCreator
    public Task(@JsonProperty("id") long id,
                @JsonProperty("orderId") long orderId,
                @JsonProperty("registered") LocalDateTime registered,
                @JsonProperty("completed") boolean completed) {
        this.id = id;
        this.orderId = orderId;
        this.registered = registered;
        this.completed = completed;
    }

    public Task(Task task) {
        this.id = task.getId();
        this.orderId = task.getOrderId();
        this.registered = task.getRegistered();
        this.completed = task.isCompleted();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", registered=" + registered +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                orderId == task.orderId &&
                completed == task.completed &&
                registered.equals(task.registered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, registered, completed);
    }
}
