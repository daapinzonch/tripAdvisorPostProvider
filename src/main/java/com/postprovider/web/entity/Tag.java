package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;


@Data
@NoArgsConstructor
public class Tag implements Serializable {



    @NotBlank
    private String description;
    @NotBlank
    private String name;

    public Tag(@NotBlank String description, @NotBlank String name) {
        this.description = description;
        this.name = name;

    }
}
