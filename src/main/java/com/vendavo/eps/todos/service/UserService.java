package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IExternalUserClient externalUserClient;

    public UserService(IExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    @Override
    public List<User> getUsers() {
        return externalUserClient.getUsers();
    }

    @Override
    public User getUser(long id) {
        return getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
