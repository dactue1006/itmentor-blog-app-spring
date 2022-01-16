package com.example.itmentor.services.impl;

import com.example.itmentor.models.Post;
import com.example.itmentor.repositories.PostRepository;
import com.example.itmentor.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
