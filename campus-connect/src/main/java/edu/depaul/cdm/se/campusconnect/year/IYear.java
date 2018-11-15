package edu.depaul.cdm.se.campusconnect.year;

public interface IYear {

	boolean equals(Object object);
	
	Long getId();
	
	String getYearName();
	
	void setId(Long id);
	
	void setYearName(String year_name);
}
