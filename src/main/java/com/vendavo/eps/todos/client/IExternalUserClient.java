package com.vendavo.eps.todos.client;

import com.vendavo.eps.todos.domain.Post;
import com.vendavo.eps.todos.domain.Todo;
import com.vendavo.eps.todos.domain.User;

import java.util.List;

public interface IExternalUserClient {

    List<User> getUsers();

    List<Todo> getTodos();

    List<Post> getPosts();
}
