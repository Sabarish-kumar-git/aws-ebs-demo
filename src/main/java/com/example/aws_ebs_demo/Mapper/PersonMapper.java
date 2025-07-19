package com.example.aws_ebs_demo.Mapper;

import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Entity.Person;

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
}
