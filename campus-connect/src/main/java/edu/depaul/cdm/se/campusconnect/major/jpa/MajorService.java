package edu.depaul.cdm.se.campusconnect.major.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.depaul.cdm.se.campusconnect.major.IMajor;
import edu.depaul.cdm.se.campusconnect.major.IMajorService;

public class MajorService implements IMajorService {

	private EntityManager em;
	
	public MajorService() {
		em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
	}
	
	@Override
	public void deleteMajor(long id) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        Major major = em.find(Major.class, id);
        em.remove(major);
        tx.commit();

	}

	@Override
	public List<IMajor> getAllMajors() {
		return em.createNamedQuery("findAllMajors").getResultList();
	}

	@Override
	public void saveMajor(IMajor major) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        IMajor majorToUpdate;
        
        if((major.getId() != null) && (major.getId() > 0)){
        	majorToUpdate = em.find(Major.class, major.getId());
        	majorToUpdate.setMajorName(major.getMajorName());
        }
        else {
        	majorToUpdate = major;
        }
        
        em.persist(majorToUpdate);
        tx.commit();

	}

}
