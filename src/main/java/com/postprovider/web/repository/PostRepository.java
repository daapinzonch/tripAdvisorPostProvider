package com.postprovider.web.repository;

import com.postprovider.web.entity.Post;
import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {
    
}
