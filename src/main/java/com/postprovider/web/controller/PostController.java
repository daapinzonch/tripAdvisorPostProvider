package com.postprovider.web.controller;

import com.postprovider.web.entity.Post;
import com.postprovider.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController{

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAll(){
        List<Post> posts = this.postService.getAll();
        return posts;
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable ("id") String id){
        Post post = this.postService.getPostById(id);
        return post;
    }


    @GetMapping("/reservation/")
    public List<Post> getByIdList(@RequestParam List<String> ids){
        return this.postService.getPostsByIds(ids);
    }

    @PostMapping
    public void createPost(@RequestBody Post post){
        this.postService.createPost(post);
    }

    @PutMapping
    public void updatePost(@RequestBody Post post){
         this.postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String postId){
        this.postService.deletePostById(postId);
    }

    @GetMapping ("/type/{type}")
    public List<Post> getByType(@PathVariable("type") String type){

        List<Post> posts = this.postService.findByServiceType(type);
        return posts;

    }

    @GetMapping ("/provider/{id}")
    public List<Post> getByProvider(@PathVariable("id") String id){

        List<Post> posts = this.postService.findByProviderId(id);
        return posts;

    }


}
