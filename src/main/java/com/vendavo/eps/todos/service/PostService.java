package com.vendavo.eps.todos.service;

import com.vendavo.eps.todos.client.IExternalUserClient;
import com.vendavo.eps.todos.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    private final IExternalUserClient externalUserClient;

    public PostService(IExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    @Override
    public List<Post> getPosts() {
        return externalUserClient.getPosts();
    }

    @Override
    public List<Post> getPostsByUserId(long userId) {
        return getPosts().stream()
                .filter(post -> post.getUserId() == userId)
                .toList();
    }
}
