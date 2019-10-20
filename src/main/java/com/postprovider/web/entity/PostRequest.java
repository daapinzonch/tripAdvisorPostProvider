package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostRequest {


    @NotNull
    private String providerId;

    @Size(min = 1, max = 128, message = "Name must be between 1 and 128 characters")
    private String name;

    @NotBlank
    private String serviceType;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90° and 90°")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90° and 90°")
    private Double latitude;

    @DecimalMin(value = "0.0", message = "Longitude must be between 0° and 180°")
    @DecimalMax(value = "180.0", message = "Longitude must be between 0° and 180°")
    private Double longitude;

    @NotBlank
    private String address;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    private String telephone;

    @PositiveOrZero
    private BigDecimal price;


    private List<Tag> tags;
    private List<String> commentIds;





}
