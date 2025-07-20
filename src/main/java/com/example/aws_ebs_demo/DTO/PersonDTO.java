package com.example.aws_ebs_demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for Person entity.
 * Used to transfer data between layers without exposing the entity directly.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private String personName;
    private String personContact;
}
