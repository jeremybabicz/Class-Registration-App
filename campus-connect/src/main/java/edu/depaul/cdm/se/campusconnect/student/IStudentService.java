package edu.depaul.cdm.se.campusconnect.student;

import java.util.List;


public interface IStudentService {
	
	void deleteStudent(int studentId);

    List<IStudent> getAllStudents();

    void saveStudent(IStudent student);
}
