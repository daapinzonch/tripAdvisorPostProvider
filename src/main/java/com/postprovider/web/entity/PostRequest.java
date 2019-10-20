package com.postprovider.web.entity;


import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@Data
public class PostRequest {



    private String providerId;

    @Size(min = 1, max = 128, message = "Name must be between 1 and 128 characters")
    private String name;


    private String serviceType;


    @DecimalMin(value = "-90.0", message = "Latitude must be between -90° and 90°")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90° and 90°")
    private Double latitude;


    @DecimalMin(value = "0.0", message = "Longitude must be between 0° and 180°")
    @DecimalMax(value = "180.0", message = "Longitude must be between 0° and 180°")
    private Double longitude;


    private String address;
    private String postalCode;
    private String city;
    private String telephone;

    @PositiveOrZero
    private BigDecimal price;
    private HashSet<Tag> tags;
    private HashSet<String> commentIds;





}
