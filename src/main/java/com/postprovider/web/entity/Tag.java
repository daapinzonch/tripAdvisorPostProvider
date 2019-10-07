package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {



    @NotBlank
    private String description;
    @NotBlank
    private String name;




}
