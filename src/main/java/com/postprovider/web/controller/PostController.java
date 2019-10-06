package com.postprovider.web.controller;

import com.postprovider.web.entity.Post;
import com.postprovider.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController{


    @Autowired
    private PostRepository postRepository;

    @GetMapping("/all")
    public List<Post> getAll(){
        List<Post> posts = this.postRepository.findAll();
        return posts;
    }

    @PutMapping
    public void createPost(@RequestBody Post post){
        this.postRepository.insert(post);
    }

    @PostMapping
    public void updatePost(@RequestBody Post post){
         this.postRepository.save(post);
    }







}
