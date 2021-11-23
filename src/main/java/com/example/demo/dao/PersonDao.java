package com.example.demo.dao;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Person;

@Component
public class PersonDao {

    private final PersonRepository personRepository;

    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPersonData(Person person) {
        return personRepository.insert(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonInformationById(String id) {
        return personRepository.findById(id);
    }

    public Person updatePersonUsingId(String id, Person person) {
        Optional<Person> findPersonQuery = personRepository.findById(id);
        Person personValues = findPersonQuery.get();
        personValues.setId(id);
        personValues.setName(person.getName());
        return personRepository.save(personValues);
    }

    public void deletePersonUsingId(String id) {
        try {
            personRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
