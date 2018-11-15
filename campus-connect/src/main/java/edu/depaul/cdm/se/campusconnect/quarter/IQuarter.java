package edu.depaul.cdm.se.campusconnect.quarter;

public interface IQuarter {
	boolean equals(Object object);
	
	Long getId();
	
	String getQuarterName();
	
	void setId(Long id);
	
	void setQuarterName(String quarter_name);
}
