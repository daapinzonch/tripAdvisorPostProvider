package com.postprovider.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.validation.constraints.NotBlank;
import java.io.Serializable;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {



    @NotBlank
    private String description;
    @NotBlank
    private String name;




}
