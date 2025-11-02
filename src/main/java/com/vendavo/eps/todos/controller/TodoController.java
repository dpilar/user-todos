package com.vendavo.eps.todos.controller;

import com.vendavo.eps.todos.domain.Todo;
import com.vendavo.eps.todos.service.ITodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/ven-todos", produces = APPLICATION_JSON_VALUE)
public class TodoController {

    private final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping(value = "/filter")
    public List<Todo> getTodosByUserName(@RequestParam("username") String userName) {
        return todoService.getTodosByUserName(userName);
    }
}
