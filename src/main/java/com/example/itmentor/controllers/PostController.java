package com.example.itmentor.controllers;

import com.example.itmentor.models.Post;
import com.example.itmentor.repositories.PostRepository;
import com.example.itmentor.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(path = "/posts")
    public List<Post> getAllPost() {
        return postService.findAll();
    }
}
