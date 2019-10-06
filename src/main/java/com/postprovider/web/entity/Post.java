package com.postprovider.web.entity;


import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@Document(collection = "Post")
public class Post implements Serializable {
    @Id
    @NotNull
    private String id;



    @NotBlank
    private String providerId;
    private String name;
    private String serviceType;
    private Double latitude;
    private Double longitude;
    private String address;
    private String postalCode;
    private String city;
    private String telephone;


    List<String> commentIds;
    private List<Tag> tags;

    public Post(@NotBlank String providerId, String name, String serviceType, Double latitude, Double longitude, String address, String postalCode, String city, String telephone, List<String> commentIds,  List<Tag> tags) {

        this.providerId = providerId;
        this.name = name;
        this.serviceType = serviceType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.telephone = telephone;
        this.commentIds = commentIds;
        this.tags = tags;
    }

    public void addComment(String postId) {

        commentIds.add(postId);
    }
}
