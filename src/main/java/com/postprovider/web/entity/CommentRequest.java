package com.postprovider.web.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Data
public class CommentRequest {


    @Id
    @NotNull
    private String id;

    @NotEmpty
    private String clientId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @Positive
    @Max(value = 5)
    @Min(value = 0)
    private Short rating;
}
