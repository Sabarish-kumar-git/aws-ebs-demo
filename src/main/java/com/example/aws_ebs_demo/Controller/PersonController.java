package com.example.aws_ebs_demo.Controller;


import com.example.aws_ebs_demo.DTO.PersonDTO;
import com.example.aws_ebs_demo.Service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        logger.info("Fetching person with ID: {}", id);
        try {
            PersonDTO personDTO = personService.findPersonById(id);
            logger.info("Person found: {}", personDTO);
            return ResponseEntity.ok(personDTO);
        }
        catch (Exception e) {
            logger.error("Error fetching person with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with ID: " + id);
        }
    }
}

