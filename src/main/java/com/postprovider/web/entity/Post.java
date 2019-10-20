package com.postprovider.web.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@Document(collection = "Post")
public class Post implements Serializable {

    public Post(@NotNull String id, @NotNull String providerId, @Size(min = 1, max = 128, message = "Name must be between 1 and 128 characters") String name, @NotBlank String serviceType, @DecimalMin(value = "-90.0", message = "Latitude must be between -90° and 90°") @DecimalMax(value = "90.0", message = "Latitude must be between -90° and 90°") Double latitude, @DecimalMin(value = "0.0", message = "Longitude must be between 0° and 180°") @DecimalMax(value = "180.0", message = "Longitude must be between 0° and 180°") Double longitude, @NotBlank String address, @NotBlank String postalCode, @NotBlank String city, @NotBlank String telephone, String imageUrl, LocalDateTime timeStamp, @NotNull @PositiveOrZero BigDecimal price, HashSet<String> commentIds, HashSet<Tag> tags) {
        this.id = id;
        this.providerId = providerId;
        this.name = name;
        this.serviceType = serviceType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.telephone = telephone;
        this.imageUrl = imageUrl;
        this.timeStamp = LocalDateTime.now();
        this.price = price;
        this.commentIds = commentIds;
        this.tags = tags;
    }

    public void updatePost(Post updatedPost) {
        this.id = updatedPost.id != null ? updatedPost.id: this.id;
        this.providerId = updatedPost.providerId != null ? updatedPost.getProviderId() : this.providerId;
        this.name = updatedPost.name != null ? updatedPost.getName(): this.name;
        this.serviceType = updatedPost.serviceType != null ? updatedPost.getServiceType(): this.serviceType;
        this.latitude = updatedPost.latitude != null ? updatedPost.getLatitude(): this.latitude;
        this.longitude = updatedPost.longitude != null ? updatedPost.getLongitude(): this.longitude;
        this.address = updatedPost.address != null ? updatedPost.getAddress(): this.address;
        this.postalCode = updatedPost.postalCode != null ? updatedPost.getPostalCode(): this.postalCode;
        this.city = updatedPost.city != null ? updatedPost.getCity(): this.city;
        this.telephone = updatedPost.telephone != null ? updatedPost.getTelephone(): this.telephone;
        this.imageUrl = updatedPost.imageUrl != null ? updatedPost.getImageUrl(): this.imageUrl;
        this.price = updatedPost.price != null ? updatedPost.getPrice(): this.price;
        if(updatedPost.getCommentIds() != null){
            this.getCommentIds().addAll(updatedPost.getCommentIds());
        }
        if(updatedPost.getCommentIds() != null){
            updatedPost.getCommentIds().forEach(this::addComment);
        }
        if(updatedPost.getTags() != null){
            updatedPost.getTags().forEach(this::addTag);
        }

    }



    @Id
    @NotNull
    private String id;


    public Post(PostRequest postRequest) {
        this.providerId = postRequest.getProviderId();
        this.name = postRequest.getName();
        this.serviceType = postRequest.getServiceType();
        this.latitude = postRequest.getLatitude();
        this.longitude = postRequest.getLongitude();
        this.address = postRequest.getAddress();
        this.postalCode = postRequest.getPostalCode();
        this.city = postRequest.getCity();
        this.telephone = postRequest.getTelephone();
        this.timeStamp = LocalDateTime.now();
        this.price = postRequest.getPrice();
        this.commentIds = postRequest.getCommentIds() != null ? postRequest.getCommentIds() : new HashSet<>();
        this.tags = postRequest.getTags() != null ? postRequest.getTags(): new HashSet<>();
    }



    @NotNull
    private String providerId;

    @Size(min = 1, max = 128, message = "Name must be between 1 and 128 characters")
    private String name;

    @NotBlank
    private String serviceType;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90° and 90°")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90° and 90°")
    private Double latitude;

    @DecimalMin(value = "0.0", message = "Longitude must be between 0° and 180°")
    @DecimalMax(value = "180.0", message = "Longitude must be between 0° and 180°")
    private Double longitude;

    @NotBlank
    private String address;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String telephone;
    private String imageUrl;
    public LocalDateTime timeStamp;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    private HashSet<String> commentIds;
    private HashSet<Tag> tags;



    public void addComment(String postId) {
        if(!commentIds.contains(postId)) commentIds.add(postId);
    }
    public void deleteComment(String postId) {
        commentIds.remove(postId);
    }



    public int addTag(Tag tag) {
        if(!tags.contains(tag)) tags.add(tag);
        return tags.size();
    }

    public int removeTag(Tag tag) {
        tags.remove(tag);
        return tags.size();
    }
}
