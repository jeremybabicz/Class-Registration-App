package edu.depaul.cdm.se.campusconnect.classpackage.jpa;

import java.util.List;

import javax.persistence.EntityTransaction;

import edu.depaul.cdm.se.campusconnect.classpackage.IClass;
import edu.depaul.cdm.se.campusconnect.classpackage.IClassService;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ClassService implements IClassService {

	private EntityManager em;
	
	 public ClassService() {
	        em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
	    }
	
	@Override
	public void deleteClass(int classId) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        Class classVar = em.find(Class.class, classId);
        em.remove(classVar);
        tx.commit();

	}

	@Override
	public List<IClass> getAllClasses() {
		return em.createNamedQuery("findAllClasses").getResultList();
	}

	@Override
	public void saveClass(IClass classVar) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IClass classVarToUpdate;
        if((classVar.getId() != null) && (classVar.getId() > 0)){
        	classVarToUpdate = em.find(Class.class, classVar.getId());
        	classVarToUpdate.setSubject(classVar.getSubject());
        	classVarToUpdate.setCourseNumber(classVar.getCourseNumber());
        	classVarToUpdate.setCourseName(classVar.getCourseName());
        	classVarToUpdate.setQuarter(classVar.getQuarter());
        } else {
        	classVarToUpdate = classVar;
        }
        
        em.persist(classVarToUpdate);
        tx.commit();

	}

}
