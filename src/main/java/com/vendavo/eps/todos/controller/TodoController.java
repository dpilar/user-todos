package com.vendavo.eps.todos.controller;

import com.vendavo.eps.todos.domain.Todo;
import com.vendavo.eps.todos.service.ITodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TodoController {

    private ITodoService todoService;

    @GetMapping(value = "/ven-todos", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }
}
