package com.postprovider.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;



@Document(collection = "Tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {



}
