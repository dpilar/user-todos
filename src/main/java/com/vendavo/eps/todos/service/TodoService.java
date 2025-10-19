package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.Todo;
import com.vendavo.eps.todos.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private final IExternalUserClient externalUserClient;

    public TodoService(IExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    @Override
    public List<Todo> getTodos() {
        return externalUserClient.getTodos();
    }

    @Override
    public List<Todo> getTodosByUserName(String userName) {
        User user = externalUserClient.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(null);

        if (user == null) {
            return List.of();
        }

        return getTodos().stream()
                .filter(todo -> todo.getUserId() == user.getId())
                .toList();
    }
}
