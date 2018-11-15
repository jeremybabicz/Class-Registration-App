package edu.depaul.cdm.se.campusconnect.student.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.se.campusconnect.student.jpa.Student;
import edu.depaul.cdm.se.campusconnect.student.spring.StudentRepository;


import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;
import edu.depaul.cdm.se.campusconnect.classpackage.spring.ClassRepository;
//import javax.persistence.EntityTransaction;
//import java.util.List;


//@Transactional
//@TestConfiguration
@SpringBootApplication
@EnableJpaAuditing
@EntityScan({"edu.depaul.cdm.se.campusconnect.student.jpa", "edu.depaul.cdm.se.campusconnect.classpackage.jpa"})
@ComponentScan({"edu.depaul.cdm.se.campusconnect.student.spring" , "edu.depaul.cdm.se.campusconnect.classpackage.spring"})
public class StudentMain implements CommandLineRunner {
	@Autowired
	StudentRepository repository;
	
	@Autowired
	ClassRepository classRepository;
	
	public static void main (String[]args){
		// TODO Auto-generated method stub
		SpringApplication app = new SpringApplication(StudentMain.class);
        app.run(args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*createExample();
		updateExample();
		deleteExample();*/
	}

	private void deleteExample() {
		System.out.println("Before delete: " + repository.count());
        repository.deleteById(new Long(1));
        System.out.println("After delete: " + repository.count());
        
        /*System.out.println("Class: ");
        System.out.println("Before delete: " + classRepository.count());
        classRepository.deleteById(new Long(1));
        System.out.println("After delete: " + classRepository.count());*/
	}

	private void updateExample() {
		Student student = repository.getOne(new Long(1));
		
		
		student.setFirstName(student.getFirstName() + "y");
		
		Iterator <Class> classIt = student.getClasses().iterator();
        while(classIt.hasNext())
        	System.out.println("Iterator =" + classIt.next().getCourseName());
        System.out.println(classRepository.count());
		repository.save(student);
		student = new Student();
		System.out.println(student.getFirstName());
		student = repository.getOne(new Long (1));
		System.out.println("New first name = " + student.getFirstName());
		
		System.out.println("Class: ");
		/*Class classObj = classRepository.getOne(new Long (1));
		System.out.println(classObj.getId());
		classObj.setCourseName(classObj.getCourseName() + " extreme");
		classRepository.save(classObj);
		System.out.println(classObj.getCourseName());
		classObj = classRepository.getOne(new Long (1));
		System.out.println("New Course name = " + classObj.getCourseName());*/
		
	}

	private void createExample() {
		System.out.println(repository.count());
        Student student = new Student();
        student.setId((long) 1);
        student.setFirstName("John");
        student.setLastName("Smith");
        
        
        List<Class> classSet = new ArrayList<Class>();
        
        classSet.addAll(classRepository.findAll());
        student.setClasses(classSet);
        
        repository.save(student);
        System.out.println(student.getFirstName() + " " + student.getLastName());
        System.out.println(repository.count());
        
       
        
       
        
        
        
        //System.out.println(classObj.getId() + " " + classObj.getCourseNumber() + " " + classObj.getCourseName());
        Iterator <Class> classIt = student.getClasses().iterator();
        
       /* while(classIt.hasNext())
        	System.out.println("Iterator =" + classIt.next().getCourseName());
        System.out.println(classRepository.count()); */
        
        
	}

}
