package ru.nazarov.restservice.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.nazarov.restservice.base.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.nazarov.restservice.utils.TaskTestData.ORDER_ID;

class CourierControllerTest extends AbstractControllerTest {
    private static final String URL = "/courier/task/";

    @Test
    void create() throws Exception{
        perform(MockMvcRequestBuilders.post(URL)
                .param("orderId", String.valueOf(ORDER_ID)))
                .andDo(print())
                .andExpect(status().isOk());

        assertFalse(repository.findByOrderId(ORDER_ID).isEmpty());
    }
}