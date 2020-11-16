package ru.nazarov.restservice.utils;

import org.springframework.test.web.servlet.ResultMatcher;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.nazarov.restservice.utils.TestUtil.readFromJsonMvcResult;
import static ru.nazarov.restservice.utils.TestUtil.readListFromJsonMvcResult;

public class Matcher<T> {
    private Class<T> clazz;

    public Matcher(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ResultMatcher contentJson(T expected) throws IOException {
        return result -> assertThat(readFromJsonMvcResult(result, clazz)).isEqualTo(expected);
    }

    public ResultMatcher contentJson(Iterable<T> expected) {
        return result -> assertThat(readListFromJsonMvcResult(result, clazz)).isEqualTo(expected);
    }
}
