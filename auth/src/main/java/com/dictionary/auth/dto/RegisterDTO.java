package com.dictionary.auth.dto;

public record RegisterDTO(
        String name,
        String email,
        String password
) {
}
