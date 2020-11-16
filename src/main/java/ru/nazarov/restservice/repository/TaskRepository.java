package ru.nazarov.restservice.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import ru.nazarov.restservice.model.Task;

import java.util.List;
import java.util.Optional;

@Mapper
@Component
public interface TaskRepository {

    @SelectKey(statement="call current value for global_seq", keyProperty="task.id", before=false, resultType=long.class)
    @Insert("INSERT INTO tasks (order_id, registered, completed) " +
            "VALUES (#{task.orderId}, #{task.registered}, #{task.completed})")
    void save(@Param("task") Task task);

    @Select("SELECT * FROM tasks ORDER BY registered")
    List<Task> findAll();

    @Select("SELECT * FROM tasks WHERE order_id = #{orderId}")
    Optional<Task> findByOrderId(@Param("orderId") long orderId);

    @Update("UPDATE tasks SET completed = true WHERE id = #{id}")
    void completed(@Param("id") long id);

    @Delete("DELETE FROM tasks WHERE id = #{id} AND completed = true")
    void deleteIfCompleted(@Param("id") long id);
}
