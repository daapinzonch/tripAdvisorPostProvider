package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Document( collection  = "Comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private String id;
    private String clientId;
    private String title;

    private String content;
    private Date date;
    private Short rating;
}
