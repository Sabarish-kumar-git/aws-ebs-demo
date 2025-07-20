package com.example.aws_ebs_demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a person in the database.
 * Maps to the PERSON_TBL table.
 */
@Entity
@Table(name = "PERSON_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int personId;

    @Column(name = "PERSON_NAME", nullable = false)
    private String personName;

    @Column(name = "PERSON_CONTACT", nullable = false)
    private String personContact;
}
