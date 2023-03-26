package com.example.mongodb.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(String lastName);
    List<Person> findByAgeGreaterThan(int age);

}
