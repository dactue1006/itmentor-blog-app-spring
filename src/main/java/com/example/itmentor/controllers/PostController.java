package com.example.itmentor.controllers;

import com.example.itmentor.dto.ApiResponse;
import com.example.itmentor.dto.PostRequestDTO;
import com.example.itmentor.exceptions.ResourceNotFoundException;
import com.example.itmentor.models.Post;
import com.example.itmentor.repositories.PostRepository;
import com.example.itmentor.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    // get all Posts
    @GetMapping("/posts")
    public List<Post> getAllPost() {
        return postService.findAll();
    }

    // Create a new Post
    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.createPost(postRequestDTO);
    }

    // Get a Single Post
    @GetMapping("/posts/{slug}")
    public Post getPostBySlug(@PathVariable(value = "slug") String slug) {
        return postService.getPostBySlug(slug);
    }

    // Update a Post
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable(value = "id") Long postId,
                           @Valid @RequestBody PostRequestDTO postRequestDTO) {
        return postService.updatePost(postId, postRequestDTO);
    }

    // Delete a Post
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
        postService.deletePost(postId);

        return ResponseEntity.ok().body(new ApiResponse(true, "Delete post successfully!"));
    }
}
