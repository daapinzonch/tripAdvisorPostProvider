package com.postprovider.web.service;

import com.postprovider.web.entity.Comment;
import com.postprovider.web.entity.Post;
import com.postprovider.web.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;
    private PostService postService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }


    public String saveComment(String postId, Comment comment) {


        String commentId;
        Post post = postService.getPostById(postId);
        if( post == null ) return null;
        Comment createdComment = commentRepository.save(comment);
        commentId = createdComment.getId();
        postService.addComment(postId , commentId);

        return commentId;

    }

    public Optional<Comment> getById(String id) {

        return commentRepository.findById(id);

    }



    public String deleteComment(String postId , String commentId) {


        String s = postService.deleteComment(postId, commentId);
        if (s == null){
            return null;
        }
        commentRepository.deleteById(commentId);
        return postId;
    }



    public List<Comment> getCommentsOfPostById(String post_id) {

        Post post = postService.getPostById(post_id);
        List<Comment> list = new ArrayList<>();
        if(post == null) return null;
        List<String> ids = post.getCommentIds();
        for (String id : ids) getById(id).ifPresent(list::add);
        return list;
    }
}
