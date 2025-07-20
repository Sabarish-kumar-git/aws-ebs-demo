package com.example.aws_ebs_demo.Service;

import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Entity.Person;
import com.example.aws_ebs_demo.Mapper.PersonMapper;
import com.example.aws_ebs_demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Person entities.
 * Provides methods to create, read, update, and delete Person records.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = new PersonMapper();

    public PersonDTO findPersonById(int id) {
        return personMapper.toDTO(personRepository.findById(id).orElse(null));
    }

    public List<PersonDTO> findAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                      .map(personMapper::toDTO)
                      .collect(Collectors.toList());
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person personEntity = personMapper.toEntity(personDTO);
        personEntity = personRepository.save(personEntity);
        return personMapper.toDTO(personEntity);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public PersonDTO updatePerson(int id, PersonDTO personDTO) {
        Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            existingPerson.setPersonName(personDTO.getPersonName());
            existingPerson.setPersonContact(personDTO.getPersonContact());
            existingPerson = personRepository.save(existingPerson);
            return personMapper.toDTO(existingPerson);
        }
        return null;
    }

}
