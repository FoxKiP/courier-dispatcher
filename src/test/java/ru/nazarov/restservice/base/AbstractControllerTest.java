package ru.nazarov.restservice.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import ru.nazarov.restservice.repository.TaskRepository;


@AutoConfigureMockMvc
public abstract class AbstractControllerTest extends AbstractTest {

    @Autowired
    protected TaskRepository repository;

    @Autowired
    private MockMvc mockMvc;

    protected ResultActions perform(RequestBuilder builder) throws Exception {
        return mockMvc.perform(builder);
    }
}
