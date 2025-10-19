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

    private List<User> users;

    @BeforeEach
    public void before() {
        client = mock(IExternalUserClient.class);
        service = new UserService(client);

        User user1 = mock(User.class);
        when(user1.getId()).thenReturn(1L);
        User user2 = mock(User.class);
        when(user2.getId()).thenReturn(2L);
        User user3 = mock(User.class);
        when(user3.getId()).thenReturn(3L);
        User user4 = mock(User.class);
        when(user4.getId()).thenReturn(4L);
        users = List.of(user1, user2, user3, user4);
        when(client.getUsers()).thenReturn(users);
    }

    @Test
    public void testGetUsers() {
        // when
        List<User> result = service.getUsers();

        // then
        assertEquals(users, result);
        verify(client).getUsers();
    }

    @Test
    public void testGetUser1() {
        // when
        User result = service.getUser(1L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(client).getUsers();
    }

    @Test
    public void testGetUser2() {
        // when
        User result = service.getUser(2L);

        // then
        assertNotNull(result);
        assertEquals(2L, result.getId());
        verify(client).getUsers();
    }

    @Test
    public void testGetUser3() {
        // when
        User result = service.getUser(3L);

        // then
        assertNotNull(result);
        assertEquals(3L, result.getId());
        verify(client).getUsers();
    }

    @Test
    public void testGetUser4() {
        // when
        User result = service.getUser(4L);

        // then
        assertNotNull(result);
        assertEquals(4L, result.getId());
        verify(client).getUsers();
    }
}
