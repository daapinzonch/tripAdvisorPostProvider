package com.postprovider.web.repository;

import com.postprovider.web.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface CommentRepository extends MongoRepository<Comment, Serializable> {


}
