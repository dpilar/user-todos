package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.Todo;
import com.vendavo.eps.todos.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    private TodoService todoService;
    private IExternalUserClient client;

    @BeforeEach
    public void before() {
        client = mock(IExternalUserClient.class);
        todoService = new TodoService(client);
    }

    @Test
    public void testGetTodos() {
        // given
        List<Todo> todos = List.of(mock(Todo.class), mock(Todo.class), mock(Todo.class));
        when(client.getTodos()).thenReturn(todos);

        // when
        List<Todo> result = todoService.getTodos();

        // then
        assertNotNull(result);
        assertEquals(todos, result);
        verify(client).getTodos();
    }

    @Test
    public void testGetTodosByUsername_UserNotFound() {
        // given
        var user = mock(User.class);
        when(user.getId()).thenReturn(1L);
        when(user.getUsername()).thenReturn("testUser");
        when(client.getUsers()).thenReturn(List.of(user));

        var todo1 = mock(Todo.class);
        when(todo1.getUserId()).thenReturn(1L);
        var todo2 = mock(Todo.class);
        when(todo2.getUserId()).thenReturn(2L);
        var todo3 = mock(Todo.class);
        when(todo3.getUserId()).thenReturn(1L);
        when(client.getTodos()).thenReturn(List.of(todo1, todo2, todo3));

        // when
        List<Todo> result = todoService.getTodosByUserName("nonexistent");

        // then
        assertNotNull(result);
        assertEquals(0, result.size());
        verify(client).getUsers();
    }

    @Test
    public void testGetTodosByUsername_UserFound() {
        // given
        var user = mock(User.class);
        when(user.getId()).thenReturn(1L);
        when(user.getUsername()).thenReturn("testUser");
        when(client.getUsers()).thenReturn(List.of(user));

        var todo1 = mock(Todo.class);
        when(todo1.getUserId()).thenReturn(1L);
        var todo2 = mock(Todo.class);
        when(todo2.getUserId()).thenReturn(2L);
        var todo3 = mock(Todo.class);
        when(todo3.getUserId()).thenReturn(1L);
        when(client.getTodos()).thenReturn(List.of(todo1, todo2, todo3));

        // when
        List<Todo> result = todoService.getTodosByUserName("testUser");

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(List.of(todo1, todo3), result);
        verify(client).getUsers();
        verify(client).getTodos();
    }
}
