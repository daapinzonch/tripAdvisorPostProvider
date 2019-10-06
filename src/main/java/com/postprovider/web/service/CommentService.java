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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;


    public String saveComment(String postId, Comment comment) {


        String commentId = "-1";
        Post post = postService.getPostById(postId);
        if( post == null ) return commentId;
        Comment createdComment = commentRepository.save(comment);
        commentId = createdComment.getId();
        postService.addComment(postId , commentId);

        return commentId;

    }

    public Optional<Comment> getById(String id) {

        return commentRepository.findById(id);

    }

    public List<Comment> getCommentsOfPost(Post post) {
        List<Comment> list = new ArrayList<>();
        List<String> ids = post.getCommentIds();
        for (String id : ids) {
            getById(id).ifPresent(comment -> list.add(comment));
        }
        return list;
    }

    public String deleteComment(String postId , String commentId) {
        commentRepository.deleteById(commentId);
        postService.deleteComment(postId, commentId);
        return postId;
    }



    public List<Comment> getCommentsOfPostById(String post_id) {

        Post post = postService.getPostById(post_id);
        List<Comment> list = new ArrayList<>();
        if(post == null) return null;
        List<String> ids = post.getCommentIds();
        for (String id : ids) getById(id).ifPresent(comment -> list.add(comment));
        return list;
    }
}
