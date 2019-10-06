package com.postprovider.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotBlank
    private String provider_id;
    private String name;

    private String serviceType;

    private Double latitude;
    private Double longitude;
    private String address;
    private String postalCode;


    private String telephone;

    private List<Tag> tags;

    private List<String> commentIds;

    public List<String> getCommentIds() {
        return commentIds;
    }

}
