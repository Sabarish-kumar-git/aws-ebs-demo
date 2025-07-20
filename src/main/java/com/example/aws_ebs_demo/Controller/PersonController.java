package com.example.aws_ebs_demo.Controller;


import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Exception.ResourceNotFoundException;
import com.example.aws_ebs_demo.Service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

