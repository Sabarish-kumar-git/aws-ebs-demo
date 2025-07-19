package com.example.aws_ebs_demo.Service;

import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Mapper.PersonMapper;
import com.example.aws_ebs_demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDTO findPersonById(int id) {
        PersonMapper personMapper = new PersonMapper();
        return personMapper.toDTO(personRepository.findById(id).orElse(null));
    }
}
