package com.postprovider.web.service;


import com.postprovider.web.entity.Post;
import com.postprovider.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //Paginacion de posts definida por el objeto pageable (no de pagina y tamano de pagina)
    public Page<Post> getAll(Pageable pageable){
        return this.postRepository.findAll(pageable);
    }

    //Obtener todos los posts en una lista
    public List<Post> getAll(){
        return this.postRepository.findAll();
    }

    //Obtener por un filtro definido por el objeto sort
    public List<Post> getByFilter(Sort sort){
        return this.postRepository.findAll(sort);
    }

    public Post createPost(Post newPost){

        return this.postRepository.save(newPost);

    }


    public Post getPostById(String id){
        return this.postRepository.getById(id);
    }


    public void updatePost(Post post) {
        this.postRepository.save(post);
    }

    public void deletePostById(String id){
        this.postRepository.deleteById(id);
    }

    public List<Post> findByServiceType(String type) {

        return this.postRepository.findByServiceType(type);
    }

    public void addComment(String postId, String comment) {

        Post post = getPostById(postId);
        post.addComment(comment);
        this.postRepository.save(post);

    }

    public List<Post> findByProviderId(String id) {

        return this.postRepository.findByProviderId(id);

    }

    public void deleteComment(String postId, String commentId) {
        Post post = this.getPostById(postId);
        if(post== null) return;
        post.deleteComment(commentId);

    }

    public List<Post> getPostsByIds(List<String> ids) {

        List<Post> posts = new ArrayList<>();
        for (String id :
                ids) {
            Post p = this.postRepository.getById(id);
            if(p!= null)
                posts.add(p);

        }
        return posts;
    }
}
