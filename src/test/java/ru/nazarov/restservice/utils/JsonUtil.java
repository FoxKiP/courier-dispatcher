package ru.nazarov.restservice.utils;

import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.util.List;

import static ru.nazarov.restservice.utils.JacksonObjectMapper.getMapper;


public class JsonUtil {
    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return getMapper().readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid read from JSON:\n'" + json + "'", e);
        }
    }

    public static <T> List<T> readValuesToList(String json, Class<T> clazz) {
        ObjectReader objectReader = getMapper().readerFor(clazz);
        try {
            return objectReader.<T>readValues(json).readAll();
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid read array from JSON:\n'" + json + "'", e);
        }
    }
}
