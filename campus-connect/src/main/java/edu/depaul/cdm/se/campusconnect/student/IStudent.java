package edu.depaul.cdm.se.campusconnect.student;

import java.util.List;
import java.util.Set;

import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;

public interface IStudent {
	boolean equals(Object object);
	
	Long getId();
	
	String getFirstName();
	
	String getLastName();
	
	String getYear();
	
	String getStudentType();
	
	String getMajor();
	
	List<Class> getClasses();
	
	int hashCode();
	
	void setClasses(List<Class> classes);
	
	void setId(Long student_id);
	
	void setFirstName(String f_name);
	
	void setLastName(String l_name);
	
	void setYear(String year);
	
	void setStudentType(String student_type);
	
	void setMajor(String major);
	
	String toString();
}
