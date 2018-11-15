package edu.depaul.cdm.se.campusconnect.year.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.depaul.cdm.se.campusconnect.year.jpa.Year;

public interface YearRepository extends MongoRepository<Year, Long> {

}
