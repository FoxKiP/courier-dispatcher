package ru.nazarov.restservice.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("задание не найдено");
    }
}
