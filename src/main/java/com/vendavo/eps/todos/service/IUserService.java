package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.domain.User;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    User getUser(long id);
}
