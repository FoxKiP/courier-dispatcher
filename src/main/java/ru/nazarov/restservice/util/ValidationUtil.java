package ru.nazarov.restservice.util;

import ru.nazarov.restservice.exception.ValidationException;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static void validOrderId(String orderId) {
        if(!Pattern.matches("[0-9]+", orderId)) {
            throw new ValidationException("только положительные числа");
        }
    }
}
