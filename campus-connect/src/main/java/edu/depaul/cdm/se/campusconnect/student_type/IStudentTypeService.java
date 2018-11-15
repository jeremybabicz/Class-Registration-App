package edu.depaul.cdm.se.campusconnect.student_type;

import java.util.List;

public interface IStudentTypeService {

	void deleteStudentType(Long id);
	
	List <IStudentType> getAllStudentTypes();
	
	void saveStudentType(IStudentType student_type);
}
