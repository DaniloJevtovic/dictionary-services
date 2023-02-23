package com.dictionary.sentence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sentence;
    private String translate;
    private String description;
    @Column(name = "sg_id")
    private Integer sgId;
    @Column(name = "dic_id")
    private Integer dicId;
}
