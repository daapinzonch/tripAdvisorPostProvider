package com.postprovider.web.service;


import com.postprovider.web.entity.Post;
import com.postprovider.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //Paginacion de posts definida por el objeto pageable (no de pagina y tamano de pagina)
    public Page<Post> getAll(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    //Obtener todos los posts en una lista
    public List<Post> getAll(){
        return postRepository.findAll();
    }

    //Obtener por un filtro definido por el objeto sort
    public List<Post> getByFilter(Sort sort){
        return postRepository.findAll(sort);
    }

    public Post createPost(Post newPost){
        return postRepository.save(newPost);
    }

}
