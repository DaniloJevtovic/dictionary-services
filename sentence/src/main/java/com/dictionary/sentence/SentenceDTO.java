package com.dictionary.sentence;

public record SentenceDTO(
        String sentence,
        String translate,
        String description,
        Integer sgId,
        Integer dicId
) {
}
