package edu.depaul.cdm.se.campusconnect.student.jpa;

import java.util.List;

import edu.depaul.cdm.se.campusconnect.student.IStudent;
import edu.depaul.cdm.se.campusconnect.student.IStudentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentService implements IStudentService {
	
	private EntityManager em;

    public StudentService() {
        em = Persistence.createEntityManagerFactory("jpa-demoPU").createEntityManager();
    }
	
	@Override
	public void deleteStudent(int studentId) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        Student student = em.find(Student.class, studentId);
        em.remove(student);
        tx.commit();

	}

	@Override
	public List<IStudent> getAllStudents() {
		
		return em.createNamedQuery("findAllStudents").getResultList();
	}

	@Override
	public void saveStudent(IStudent student) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IStudent studentToUpdate;
        if((student.getId() != null) && (student.getId() > 0)){
        	studentToUpdate = em.find(Student.class, student.getId());
        	studentToUpdate.setFirstName(student.getFirstName());
        	studentToUpdate.setLastName(student.getLastName());
        	studentToUpdate.setYear(student.getYear());
        	studentToUpdate.setMajor(student.getMajor());
        } else {
        	studentToUpdate = student;
        }
        
        em.persist(studentToUpdate);
        tx.commit();
	}

}
