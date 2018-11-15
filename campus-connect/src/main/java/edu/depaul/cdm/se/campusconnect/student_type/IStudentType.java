package edu.depaul.cdm.se.campusconnect.student_type;

public interface IStudentType {
	boolean equals(Object object);
	
	Long getId();
	
	String getStudentTypeName();
	
	void setId(Long id);
	
	void setStudentTypeName(String type_name);
}
