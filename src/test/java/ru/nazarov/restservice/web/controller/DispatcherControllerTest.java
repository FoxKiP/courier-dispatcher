package ru.nazarov.restservice.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.nazarov.restservice.base.AbstractControllerTest;
import ru.nazarov.restservice.model.Task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.nazarov.restservice.utils.TaskTestData.*;



class DispatcherControllerTest extends AbstractControllerTest {
    private static final String URL = "/dispatcher/task/";

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MATCHER.contentJson(getTasks()));
    }

    @Test
    void getByOrderId() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "search")
                .param("orderId", String.valueOf(TASK_3.getOrderId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MATCHER.contentJson(TASK_3));
    }

    @Test
    void completed() throws Exception{
        perform(MockMvcRequestBuilders.put(URL + "completed/" + TASK_3.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        Task expected = getNew(TASK_3);
        expected.setCompleted(true);
        assertThat(repository.findByOrderId(TASK_3.getOrderId()).get()).isEqualTo(expected);
    }

    @Test
    void deleteIfCompleted() throws Exception {
        repository.completed(TASK_3.getId());

        perform(MockMvcRequestBuilders.delete(URL + "delete/" + TASK_3.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        assertTrue(repository.findByOrderId(TASK_3.getOrderId()).isEmpty());
    }
}