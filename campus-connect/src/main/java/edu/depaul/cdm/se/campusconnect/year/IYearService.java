package edu.depaul.cdm.se.campusconnect.year;

import java.util.List;

public interface IYearService {

	void deleteYear(long id);
	
	List<IYear> getAllYears();
	
	void saveYear(IYear year);
}
