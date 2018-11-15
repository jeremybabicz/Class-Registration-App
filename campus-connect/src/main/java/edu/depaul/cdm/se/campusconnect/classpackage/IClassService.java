package edu.depaul.cdm.se.campusconnect.classpackage;

import java.util.List;

public interface IClassService {

	void deleteClass(int classId);
	
	List<IClass> getAllClasses();
	
	void saveClass(IClass classVar);
}
