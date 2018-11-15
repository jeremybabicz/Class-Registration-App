package edu.depaul.cdm.se.campusconnect.student_type.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.depaul.cdm.se.campusconnect.student_type.IStudentType;
import edu.depaul.cdm.se.campusconnect.student_type.IStudentTypeService;

public class StudentTypeService implements IStudentTypeService {

	private EntityManager em;
	
	public StudentTypeService () {
		em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
	}
	@Override
	public void deleteStudentType(Long id) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        StudentType studentType = em.find(StudentType.class, id);
        em.remove(studentType);
        tx.commit();

	}

	@Override
	public List<IStudentType> getAllStudentTypes() {
		return em.createNamedQuery("findAllStudentTypes").getResultList();
	}

	@Override
	public void saveStudentType(IStudentType student_type) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        IStudentType studentTypeToUpdate;
        
        if((student_type.getId() != null) && (student_type.getId() > 0)){
        	studentTypeToUpdate = em.find(StudentType.class, student_type.getId());
        	studentTypeToUpdate.setStudentTypeName(student_type.getStudentTypeName());
        }
        else {
        	studentTypeToUpdate = student_type;
        }
        
        em.persist(studentTypeToUpdate);
        tx.commit();

	}

}
