package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.Todo;
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
}
