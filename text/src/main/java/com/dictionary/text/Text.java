package com.dictionary.text;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Text {

    @Id
    private String id;
    private String title;
    private String text;
    private String translate;
    private Boolean favorite;
    private Integer dicId;

}
