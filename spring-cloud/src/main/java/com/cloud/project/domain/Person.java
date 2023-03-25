package com.cloud.project.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public void setId(Long id) {
        this.id = id;
    }
}
