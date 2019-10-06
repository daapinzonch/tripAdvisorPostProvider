package com.postprovider.web.controller;


import com.postprovider.web.entity.Comment;
import com.postprovider.web.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping ("/ofPost/{id}")
    public List<Comment> getCommentsOfPost(@PathVariable ("id") String id){

        return this.commentService.getCommentsOfPostById(id);


    }

    @PutMapping ("/{postId}")
    public String newComment(@PathVariable ("postId") String postId, @RequestBody Comment comment){

        return commentService.saveComment(postId, comment);


    }

}
