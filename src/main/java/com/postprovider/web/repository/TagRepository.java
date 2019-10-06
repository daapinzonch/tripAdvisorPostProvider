package com.postprovider.web.repository;

import com.postprovider.web.entity.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {

}
