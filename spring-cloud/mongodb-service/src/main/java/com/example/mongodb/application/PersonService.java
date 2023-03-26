package com.example.mongodb.application;

import com.example.mongodb.domain.Person;
import com.example.mongodb.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(String id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 ID입니다."));
    }

    @Transactional
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public void delete(String id) {
        personRepository.deleteById(id);
    }

    public List<Person> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public List<Person> findByAgeGreaterThan(@RequestParam("age") int age) {
        return personRepository.findByAgeGreaterThan(age);
    }

}
