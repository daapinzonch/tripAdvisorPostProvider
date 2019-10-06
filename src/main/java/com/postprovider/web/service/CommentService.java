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

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
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

    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

}
