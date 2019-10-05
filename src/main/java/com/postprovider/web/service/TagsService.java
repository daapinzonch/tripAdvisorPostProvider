package com.postprovider.web.service;


import com.postprovider.web.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

}
