package com.postprovider.web.repository;

import com.postprovider.web.entity.Post;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {



    @Override
    <S extends Post> List<S> saveAll(Iterable<S> iterable);
    @Override
    List<Post> findAll();
    List<Post> findByServiceType(String serviceType);
    Post getById(String id);
    List<Post> findByProviderId(@NotBlank String providerId);
    List<Post> findAllById(List<String> ids);

}
