package com.codekul.java21febspring.dbrefemongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
public class Sports {
    @MongoId
    private String id;

    private String sportsName;


}
