package com.postprovider.web.controller;


import com.postprovider.web.entity.Comment;
import com.postprovider.web.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value="Comments", produces = "application/json")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "Get all the comments of a given Post by its Id." , response = List.class)
    @GetMapping ("/{id}")
    public List<Comment> getCommentsOfPost(@PathVariable ("id") String id){
        return this.commentService.getCommentsOfPostById(id);
    }

    @ApiOperation(value = "Create and post a new comment of a given Post by its Id." , response = String.class)
    @PutMapping ("/{postId}")
    public String createComment(@PathVariable ("postId") String postId, @RequestBody Comment comment){
        return commentService.saveComment(postId, comment);
    }

    @ApiOperation(value = "Delete a comment by Id, of a given Post by its Id." , response = String.class)
    @DeleteMapping ("/")
    public String deleteComment(@RequestParam String postId, @RequestParam String commentId){
        return commentService.deleteComment(postId, commentId);
    }

}
