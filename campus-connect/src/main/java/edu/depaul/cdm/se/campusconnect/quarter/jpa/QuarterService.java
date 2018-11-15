package edu.depaul.cdm.se.campusconnect.quarter.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.depaul.cdm.se.campusconnect.quarter.IQuarter;
import edu.depaul.cdm.se.campusconnect.quarter.IQuarterService;

public class QuarterService implements IQuarterService {

	private EntityManager em;
	
	public QuarterService() {
		em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
	}
	
	@Override
	public void deleteQuarter(Long id) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        Quarter quarter = em.find(Quarter.class, id);
        em.remove(quarter);
        tx.commit();
	}

	@Override
	public List<IQuarter> getAllQuarters() {
		return em.createNamedQuery("findAllQuarters").getResultList();
	}

	@Override
	public void saveQuarter(IQuarter quarter) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        IQuarter quarterToUpdate;
        
        if((quarter.getId() != null) && (quarter.getId() > 0)){
        	quarterToUpdate = em.find(Quarter.class, quarter.getId());
        	quarterToUpdate.setQuarterName(quarter.getQuarterName());
        }
        else {
        	quarterToUpdate = quarter;
        }
        
        em.persist(quarterToUpdate);
        tx.commit();

	}

}
