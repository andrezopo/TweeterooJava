package com.tweeteroo.tweeteroo.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(


@NotBlank
String text


) {
    
}
