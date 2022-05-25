package com.dictionary.word;

public record WordDTO(
        String word,
        String translate,
        String description,
        WordType type,
        Integer wgId,
        Integer dicId
) {
}
