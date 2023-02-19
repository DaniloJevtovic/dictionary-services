package com.dictionary.word;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String word;
    private String translate;
    private String description;
    private WordType type;
    private Integer wgId;
    private Integer dicId;
}
