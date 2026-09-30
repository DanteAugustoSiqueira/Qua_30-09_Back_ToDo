
package com.example.back_todo.repository;

import com.example.back_todo.entidade.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    void deleteAllByName(String name);
}
