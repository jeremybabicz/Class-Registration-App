package edu.depaul.cdm.se.campusconnect.student.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.se.campusconnect.student.jpa.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{

}
