package com.postprovider.web.service;


import com.postprovider.web.entity.Tag;
import com.postprovider.web.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    public Tag saveTag(Tag tag){
        return tagRepository.save(tag);
    }

}
