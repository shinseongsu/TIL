package com.example.mongodb.ui;

import com.example.mongodb.application.PersonCounterService;
import com.example.mongodb.application.PersonService;
import com.example.mongodb.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonCounterService counterService;
    private final PersonService personService;

    private List<Person> persons = new ArrayList<>();

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person add(@RequestBody Person person) {
        person = personService.save(person);
        counterService.countNewPersons();
        return person;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        personService.delete(id);
        counterService.countDeletedPersons();
    }

    @GetMapping("/lastname/{lastName}")
    public List<Person> findByLastName(@PathVariable("lastName") String lastName) {
        return personService.findByLastName(lastName);
    }

    @GetMapping("/age/{age}")
    public List<Person> findByAgeGreaterThan(@PathVariable("age") int age) {
        return personService.findByAgeGreaterThan(age);
    }

}
