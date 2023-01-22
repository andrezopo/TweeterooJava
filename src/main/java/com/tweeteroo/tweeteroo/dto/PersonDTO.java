package com.tweeteroo.tweeteroo.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;

public record PersonDTO(
    
@NotBlank
String username, 

@NotBlank
@URL
String avatar) {
}
