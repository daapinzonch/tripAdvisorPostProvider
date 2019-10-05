package com.postprovider.web.repository;
import com.postprovider.web.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface  TagRepository  extends MongoRepository<Tag, Serializable> {



}
