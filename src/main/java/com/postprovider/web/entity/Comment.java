package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;



@Document( collection  = "Comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id
    @NotNull
    private String id;

    @NotEmpty
    private String clientId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @PastOrPresent
    private Date date;

    @Positive
    private Short rating;


}
