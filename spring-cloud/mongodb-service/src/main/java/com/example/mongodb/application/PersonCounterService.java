package com.example.mongodb.application;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class PersonCounterService {

    private final Counter personAddCounter;
    private final Counter personDeleteCounter;

    public PersonCounterService(MeterRegistry registry) {
        this.personAddCounter = registry.counter("services.person.add");
        this.personDeleteCounter = registry.counter("services.person.deleted");
    }

    public void countNewPersons() {
        this.personAddCounter.increment();
    }

    public void countDeletedPersons() {
        this.personDeleteCounter.increment();
    }

}
