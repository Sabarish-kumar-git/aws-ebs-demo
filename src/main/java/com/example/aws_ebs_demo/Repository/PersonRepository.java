package com.example.aws_ebs_demo.Repository;

import com.example.aws_ebs_demo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Person entity.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
