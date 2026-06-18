package com.rapido.platformengineering.dto;

public record DocumentationResponse(

        Long id,
        String title,
        String category,
        String content

) {
}