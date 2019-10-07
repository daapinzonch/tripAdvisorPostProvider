package com.postprovider.web.entity;


import com.sun.istack.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Post")
public class Post implements Serializable {
    @Id
    @NotNull
    private String id;



    @NotNull
    private String providerId;

    @Size(min = 1, max = 128, message = "Name must be between 1 and 128 characters")
    private String name;

    @NotBlank
    private String serviceType;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90° and 90°")
    @DecimalMin(value = "90.0", message = "Latitude must be between -90° and 90°")
    private Double latitude;

    @DecimalMax(value = "0.0", message = "Longitude must be between 0° and 180°")
    @DecimalMin(value = "180.0", message = "Longitude must be between 0° and 180°")
    private Double longitude;

    @NotBlank
    private String address;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String telephone;

    @PastOrPresent
    public LocalDateTime timeStamp;

    @PositiveOrZero
    private BigDecimal price;


    List<String> commentIds;

    private List<Tag> tags;



    public void addComment(String postId) {
        commentIds.add(postId);
    }

    public void deleteComment(String postId) {
        commentIds.remove(postId);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }
}
