package com.example.itmentor.services.impl;

import com.example.itmentor.dto.PostRequestDTO;
import com.example.itmentor.exceptions.ResourceNotFoundException;
import com.example.itmentor.models.Post;
import com.example.itmentor.repositories.PostRepository;
import com.example.itmentor.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(PostRequestDTO postRequestDTO) {
        Post newPost = new Post();

        // Assign title and content from postRequestDTO
        newPost.setTitle(postRequestDTO.getTitle());
        newPost.setContent(postRequestDTO.getContent());

        // generate slug from title
        String slug = postRequestDTO.getTitle().trim().toLowerCase().replaceAll("\\s+", "-") + "-" + new Date().getTime();
        newPost.setSlug(slug);

        return postRepository.save(newPost);
    }

    @Override
    public Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug).orElseThrow(() -> new ResourceNotFoundException("Post", "slug", slug));
    }
}
