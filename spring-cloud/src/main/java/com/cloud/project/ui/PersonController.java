package com.cloud.project.ui;

import com.cloud.project.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    @GetMapping
    public List<Person> findAll() {
        return persons;
    }

    @GetMapping("/{id}")
    public Person findById(@RequestParam("id") Long id) {
        return persons.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .get();
    }

    @PostMapping
    public Person add(@RequestBody Person person) {
        person.setId((long) (persons.size() + 1));
        persons.add(person);

        return person;
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") Long id) {
        List<Person> personList = persons.stream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());

        persons.removeAll(personList);
    }

    @PutMapping
    public void update(@RequestBody Person person) {
        Person newPerson = persons.stream()
                .filter(it -> it.getId().equals(person.getId()))
                .findFirst()
                .get();

        persons.set(persons.indexOf(newPerson), person);
    }

}
