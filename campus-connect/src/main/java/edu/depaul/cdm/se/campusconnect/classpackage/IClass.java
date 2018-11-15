package edu.depaul.cdm.se.campusconnect.classpackage;

import java.util.List;
import java.util.Set;

import edu.depaul.cdm.se.campusconnect.student.jpa.Student;

public interface IClass {
	boolean equals(Object object);
	
	Long getId();
	
	String getSubject();
	
	Integer getCourseNumber();
	
	String getCourseName();
	
	String getQuarter();
	
	public List<Student> getStudents();
	
	int hashCode();
	
	void setStudents(List <Student> students);
	
	void setId(Long class_id);
	
	void setSubject(String subject);
	
	void setCourseNumber(Integer course_num);
	
	void setCourseName(String course_name);
	
	void setQuarter(String quarter);
	
	String toString();
	
}
