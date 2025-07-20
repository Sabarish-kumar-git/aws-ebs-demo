package com.example.aws_ebs_demo.Mapper;

import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Entity.Person;

/**
 * Mapper class for converting between Person entity and PersonDTO.
 * This class provides methods to convert a Person object to a PersonDTO
 * and vice versa.
 */
public class PersonMapper {

    public PersonDTO toDTO(Person person) {
        if (person == null) {
            return null;
        }
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonName(person.getPersonName());
        personDTO.setPersonContact(person.getPersonContact());
        return personDTO;
    }

    public Person toEntity(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }
        Person person = new Person();
        person.setPersonName(personDTO.getPersonName());
        person.setPersonContact(personDTO.getPersonContact());
        return person;
    }
}
