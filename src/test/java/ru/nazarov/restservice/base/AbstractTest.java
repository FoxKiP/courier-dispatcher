package ru.nazarov.restservice.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {
        "classpath:db/migration/V2__populateDb.sql"
})
public abstract class AbstractTest {
}
