package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService service;
    private IExternalUserClient client;

    @BeforeEach
    public void before() {
        client = mock(IExternalUserClient.class);
        service = new UserService(client);
    }

    @Test
    public void testGetUsers() {
        // given
        List<User> users = List.of(mock(User.class), mock(User.class), mock(User.class));
        when(client.getUsers()).thenReturn(users);

        // when
        List<User> result = service.getUsers();

        // then
        assertEquals(users, result);
        verify(client).getUsers();
    }

    @Test
    public void testGetUser() {
        // given
        User user1 = mock(User.class);
        when(user1.getId()).thenReturn(1L);
        User user2 = mock(User.class);
        when(user2.getId()).thenReturn(2L);
        User user3 = mock(User.class);
        when(user3.getId()).thenReturn(3L);
        List<User> users = List.of(user1, user2, user3);
        when(client.getUsers()).thenReturn(users);

        // when
        User result = service.getUser(1L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(client, times(1)).getUsers();

        // when
        result = service.getUser(2L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(client, times(2)).getUsers();

        // when
        result = service.getUser(3L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(client, times(3)).getUsers();

        // when
        result = service.getUser(4L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(client, times(4)).getUsers();
    }
}
