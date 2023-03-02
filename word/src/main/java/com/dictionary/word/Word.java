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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String word;
    private String translate;
    private String description;
    @Enumerated(EnumType.STRING)
    private WordType type;
    private Boolean favorite;
    @Column(name = "wg_id")
    private Integer wgId;
    @Column(name = "dic_id")
    private Integer dicId;
}
