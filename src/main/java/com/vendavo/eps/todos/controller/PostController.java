package com.vendavo.eps.todos.controller;

import com.vendavo.eps.todos.domain.Post;
import com.vendavo.eps.todos.service.IPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/ven-posts", produces = APPLICATION_JSON_VALUE)
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> getPosts(@RequestParam(value = "userId", required = false) Long userId) {
        if (userId != null) {
            return postService.getPostsByUserId(userId);
        }

        return postService.getPosts();
    }
}
