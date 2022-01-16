package com.example.itmentor;

import com.example.itmentor.models.Post;
import com.example.itmentor.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        postRepository.save(new Post("This is title", "This is content", "this-is-content"));
//        postRepository.save(new Post("This is another title", "This is another content", "this-is-another-content"));
    }
}
