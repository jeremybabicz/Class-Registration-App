package edu.depaul.cdm.se.campusconnect.student_type.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.depaul.cdm.se.campusconnect.student_type.jpa.StudentType;

public interface StudentTypeRepository extends MongoRepository<StudentType, Long> {

}
