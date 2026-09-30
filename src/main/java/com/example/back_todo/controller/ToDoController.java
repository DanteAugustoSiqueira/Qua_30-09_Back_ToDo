
package com.example.back_todo.controller;

import com.example.back_todo.entidade.ToDo;
import com.example.back_todo.repository.ToDoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
// Identificando que as requisicoes veem do Angular.
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoController {
    private final ToDoRepository REPO;

    public ToDoController(ToDoRepository repo) {
        this.REPO = repo;
    }

    @GetMapping
    public List<ToDo> listarTudo() {
        return REPO.findAll();
    }

    @PostMapping
    public ToDo criar(@RequestBody ToDo atividade) {
        return REPO.save(atividade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        REPO.deleteById(id);
    }

    @DeleteMapping
    public void limpar(@RequestBody String nome) {
        REPO.deleteAllByName(nome);
    }
}
