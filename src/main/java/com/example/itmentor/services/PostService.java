package com.example.itmentor.services;

import com.example.itmentor.dto.PostRequestDTO;
import com.example.itmentor.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post createPost(PostRequestDTO postRequestDTO);

    Post getPostBySlug(String slug);
}
