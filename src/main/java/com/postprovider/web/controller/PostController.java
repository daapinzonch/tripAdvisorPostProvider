package com.postprovider.web.controller;

import com.postprovider.web.entity.Post;
import com.postprovider.web.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Api(value="PostProvider", produces = "application/json")
public class PostController{

    @Autowired
    private PostService postService;

    @ApiOperation(value = "Gets all the posts." , response = List.class)
    @GetMapping
    public List<Post> getAll(){
        List<Post> posts = this.postService.getAll();
        return posts;
    }

    @ApiOperation(value = "Gets a Post by Id." , response = Post.class)
    @GetMapping("/{id}")
    public Post getById(@PathVariable ("id") String id){
        Post post = this.postService.getPostById(id);
        return post;
    }

    @ApiOperation(value = "Gets all the posts that corresponds to a list of Ids. Used with the reservation API." , response = List.class)
    @GetMapping("/reservation/")
    public List<Post> getByIdList(@RequestParam List<String> ids){
        return this.postService.getPostsByIds(ids);
    }


    @ApiOperation(value = "Creates a new Post." , response = Post.class)
    @PostMapping
    public void createPost(@RequestBody Post post){
        this.postService.createPost(post);
    }

    @ApiOperation(value = "Updates o creates a given Post that matches the content of the request body." )
    @PutMapping
    public void updatePost(@RequestBody Post post){
         this.postService.updatePost(post);
    }

    @ApiOperation(value = "Deletes a post by Id.")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String postId){
        this.postService.deletePostById(postId);
    }

    @ApiOperation(value = "Gets all the posts that matches the type {type}." , response = Post.class)
    @GetMapping ("/type/{type}")
    public List<Post> getByType(@PathVariable("type") String type){

        List<Post> posts = this.postService.findByServiceType(type);
        return posts;

    }

    @ApiOperation(value = "Gets all the posts that matches the providerId {id}." , response = Post.class)
    @GetMapping ("/provider/{id}")
    public List<Post> getByProvider(@PathVariable("id") String id){

        List<Post> posts = this.postService.findByProviderId(id);
        return posts;

    }


}
