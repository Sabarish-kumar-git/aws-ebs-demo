package com.example.aws_ebs_demo.Controller;


import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Exception.ResourceNotFoundException;
import com.example.aws_ebs_demo.Service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Person entities.
 * Provides endpoints to create, read, update, and delete Person records.
 */
@RestController
@RequestMapping("/api")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    @GetMapping("/test")
    public String test() {
        return "EBS Demo Application is running!";
    }

    /**
     * Fetches a person by their ID.
     *
     * @param id the ID of the person to fetch
     * @return ResponseEntity containing the PersonDTO if found, or an error response if not found
     */
    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        logger.info("Fetching person with ID: {}", id);
        PersonDTO personDTO = personService.findPersonById(id);

        if(personDTO == null){
            logger.warn("Person found with ID: {}", id);
            throw new ResourceNotFoundException("Person not found with ID: " + id);
        }

        logger.info("Person found: {}", personDTO);
        return ResponseEntity.ok(personDTO);
    }

    /**
     * Fetches all persons.
     * @return ResponseEntity containing a list of PersonDTOs
     */
    @GetMapping("/persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        logger.info("Fetching all persons");
        List<PersonDTO> persons = personService.findAllPersons();
        logger.info("Total persons found: {}", persons.size());
        return ResponseEntity.ok(persons);
    }

    /**
     * Creates a new person.
     *
     * @param personDTO the PersonDTO containing the details of the person to create
     * @return ResponseEntity containing the created PersonDTO
     */
    @PostMapping("/person")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        logger.info("Creating new person: {}", personDTO);
        PersonDTO createdPerson = personService.createPerson(personDTO);
        logger.info("Created person: {}", createdPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    /**
     * Deletes a person by their ID.
     *
     * @param id the ID of the person to delete
     * @return ResponseEntity with no content if successful, or an error response if not found
     */
    @PutMapping("/person/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Integer id, @RequestBody PersonDTO personDTO) {
        logger.info("Updating person with ID: {}", id);
        PersonDTO updatedPerson = personService.updatePerson(id, personDTO);

        if (updatedPerson == null) {
            logger.warn("Person not found with ID: {}", id);
            throw new ResourceNotFoundException("Person not found with ID: " + id);
        }

        logger.info("Updated person: {}", updatedPerson);
        return ResponseEntity.ok(updatedPerson);
    }

    /**
     * Deletes a person by their ID.
     * @param id
     * @return ResponseEntity with no content if successful, or an error response if not found
     */
    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
        logger.info("Deleting person with ID: {}", id);
        personService.deletePerson(id);
        logger.info("Person with ID: {} deleted successfully", id);
        return ResponseEntity.ok().build();
    }
}

