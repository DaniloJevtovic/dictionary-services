package com.dictionary.user.dto;

public record RegisterDTO(
        String name,
        String email,
        String password
) {
}
