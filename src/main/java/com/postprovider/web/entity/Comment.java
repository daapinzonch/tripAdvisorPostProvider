package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Document( collection  = "Comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private String client_id;
    private String title;


    private String content;
    private Date date;
    private Short rating;











}
