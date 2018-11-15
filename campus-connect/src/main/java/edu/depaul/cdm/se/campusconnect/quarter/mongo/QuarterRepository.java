package edu.depaul.cdm.se.campusconnect.quarter.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.depaul.cdm.se.campusconnect.quarter.jpa.Quarter;

public interface QuarterRepository extends MongoRepository<Quarter, Long> {

}
