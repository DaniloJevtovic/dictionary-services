package com.dictionary.sentence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sentence;
    private String translate;
    private String description;
    private Integer sgId;
    private Integer dicId;
}
