package edu.depaul.cdm.se.campusconnect.quarter;

import java.util.List;

public interface IQuarterService {

	void deleteQuarter(Long id);
	
	List<IQuarter> getAllQuarters();
	
	void saveQuarter(IQuarter quarter);
}
