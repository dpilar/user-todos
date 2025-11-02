package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.domain.Post;

import java.util.List;

public interface IPostService {

    List<Post> getPosts();

    List<Post> getPostsByUserId(long userId);
}
