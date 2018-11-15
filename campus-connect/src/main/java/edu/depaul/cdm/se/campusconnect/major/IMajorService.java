package edu.depaul.cdm.se.campusconnect.major;

import java.util.List;

public interface IMajorService {
	
    void deleteMajor(long id);
	
	List<IMajor> getAllMajors();
	
	void saveMajor(IMajor major);

}
