package edu.depaul.cdm.se.campusconnect.classpackage.spring;

import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>{
	
	List<Class>findByQuarter(String quarter);
}
