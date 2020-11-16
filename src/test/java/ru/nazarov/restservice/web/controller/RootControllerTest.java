package ru.nazarov.restservice.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.nazarov.restservice.base.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RootControllerTest extends AbstractControllerTest {

    @Test
    void dispatcher() throws Exception {
        action("", "dispatcher");
    }

    @Test
    void courier() throws Exception {
        action("courier", "courier");
    }

    private void action(String url, String viewName) throws Exception {
        perform(MockMvcRequestBuilders.get("/" + url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name(viewName));
    }
}