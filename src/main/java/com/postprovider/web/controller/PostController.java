package com.postprovider.web.controller;

import com.postprovider.web.entity.Post;
import com.postprovider.web.entity.Tag;
import com.postprovider.web.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@Api(value="PostProvider", produces = "application/json")
public class PostController{

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "Gets all the posts." , response = List.class)
    @GetMapping
    public ResponseEntity<List<Post> > getAll(){
        List<Post> posts = this.postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @ApiOperation(value = "Gets a Post by Id." , response = Post.class)
    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable ("id") String id){
        Post post = this.postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @ApiOperation(value = "Gets all the posts that corresponds to a list of Ids. Used with the reservation API." , response = List.class)
    @GetMapping("/reservation/")
    public ResponseEntity<List<Post>> getByIdList(@RequestParam List<String> ids){
        List<Post> postsByIds = this.postService.getPostsByIds(ids);
        return ResponseEntity.ok(postsByIds);
    }

    @ApiOperation(value = "Gets all the posts that matches the type {type}." , response = Post.class)
    @GetMapping ("/type/{type}")
    public ResponseEntity<List<Post>> getByType(@PathVariable("type") String type){
        List<Post> posts = this.postService.findByServiceType(type);
        return ResponseEntity.ok(posts);
    }

    @ApiOperation(value = "Gets all the posts that matches the providerId {id}." , response = Post.class)
    @GetMapping ("/provider/{id}")
    public ResponseEntity<List<Post>> getByProvider(@PathVariable("id") String id){
        List<Post> posts = this.postService.findByProviderId(id);
        return ResponseEntity.ok(posts);
    }

    @ApiOperation(value = "Creates a new Post." , response = Post.class)
    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody @Valid Post post){
        try{
            Post p  = this.postService.createPost(post);
            if (p == null){
                return new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity<>(p.getId(), HttpStatus.CREATED);
            }
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.toString(), HttpStatus.FORBIDDEN);
        }
    }

    @ApiOperation(value = "Updates o creates a given Post that matches the content of the request body." )
    @PutMapping
    public ResponseEntity<String> updatePost(@RequestBody @Valid Post post){
        try {
            Post p  = this.postService.updatePost(post);
            if (p == null){
                return new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity<>(p.getId(), HttpStatus.ACCEPTED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.FORBIDDEN);
        }
    }

    @ApiOperation(value = "Deletes a post by Id.")
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId){

        try{
            if(this.postService.deletePostById(postId)){
                return new ResponseEntity<>(postId, HttpStatus.ACCEPTED);
            }
            else{
                return  new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.FORBIDDEN);
        }
    }

    @ApiOperation(value = "Adds a tag to a given Post by Id")
    @PutMapping("/tag/{postId}")
    public ResponseEntity<String> addTag(@RequestBody Tag tag, @PathVariable String postId){
        try {
            int tagsSize = this.postService.addTag(tag, postId);
            if (tagsSize == -1){
                return new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity<>(Integer.toString(tagsSize), HttpStatus.ACCEPTED);
            }
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.FORBIDDEN);
        }
    }

    @ApiOperation(value = "Removes a tag to a given Post by Id")
    @DeleteMapping("/tag/{postId}")
    public ResponseEntity<String> removeTag(@RequestBody Tag tag, @PathVariable String postId){
        try{
            int tagsSize = this.postService.removeTag(tag, postId);
            if (tagsSize == -1){
                return new ResponseEntity<>( "-1" , HttpStatus.BAD_REQUEST);
            }
            else{
                return  new ResponseEntity<>(Integer.toString(tagsSize), HttpStatus.ACCEPTED);
            }

        }catch (Exception e){

            return new ResponseEntity<>(e.toString(), HttpStatus.FORBIDDEN);
        }
    }


}
