package edu.depaul.cdm.se.campusconnect.major;

public interface IMajor {
	boolean equals(Object object);
	
	Long getId();
	
	String getMajorName();
	
	void setId(Long id);
	
	void setMajorName(String major_name);
}
