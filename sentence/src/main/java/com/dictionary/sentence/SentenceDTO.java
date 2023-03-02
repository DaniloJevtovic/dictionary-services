package com.dictionary.sentence;

public record SentenceDTO(
        String sentence,
        String translate,
        String description,
        Boolean favorite,
        Integer sgId,
        Integer dicId
) {
}
