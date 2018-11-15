package edu.depaul.cdm.se.campusconnect.major.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.depaul.cdm.se.campusconnect.major.jpa.Major;

public interface MajorRepository extends MongoRepository<Major, Long> {

}
