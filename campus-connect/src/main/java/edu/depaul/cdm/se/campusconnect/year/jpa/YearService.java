package edu.depaul.cdm.se.campusconnect.year.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.depaul.cdm.se.campusconnect.year.IYear;
import edu.depaul.cdm.se.campusconnect.year.IYearService;

public class YearService implements IYearService {

	private EntityManager em;
	
	public YearService() {
		em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
	}
	@Override
	public void deleteYear(long id) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        Year year = em.find(Year.class, id);
        em.remove(year);
        tx.commit();

	}

	@Override
	public List<IYear> getAllYears() {
		return em.createNamedQuery("findAllMajors").getResultList();

	}

	@Override
	public void saveYear(IYear year) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        IYear yearToUpdate;
        
        if((year.getId() != null) && (year.getId() > 0)){
        	yearToUpdate = em.find(Year.class, year.getId());
        	yearToUpdate.setYearName(year.getYearName());
        }
        else {
        	yearToUpdate = year;
        }
        
        em.persist(yearToUpdate);
        tx.commit();

	}

}
