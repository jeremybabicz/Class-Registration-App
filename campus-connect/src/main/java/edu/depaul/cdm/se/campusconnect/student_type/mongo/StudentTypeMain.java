package edu.depaul.cdm.se.campusconnect.student_type.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import edu.depaul.cdm.se.campusconnect.student_type.jpa.StudentType;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.campusconnect.Student_type.mongo") //used to be student_type
public class StudentTypeMain implements CommandLineRunner {
	@Autowired
	StudentTypeRepository repository;
	
	private static final Long ID = new Long(1);
	
	@Override
	public void run(String... args) throws Exception {
		/*createExample();
        updateExample();
        deleteExample();*/
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StudentTypeMain.class);
		app.run(args);

	}
	
	private void createExample() {
		System.out.println("Before create " + repository.count());
		StudentType student_type = new StudentType();
		student_type.setId(ID);
		student_type.setStudentTypeName("Undergraduate");
		
		repository.save(student_type);
		System.out.println("Student type is " + 		student_type.getStudentTypeName());
		System.out.println("After create " + repository.count());
		
	}
	
	private void updateExample() {
		StudentType student_type = repository.findById(ID).orElse(new StudentType());
		student_type.setStudentTypeName("Graduate");
		repository.save(student_type);
		System.out.println("New student typeis " + student_type.getStudentTypeName());
		
	}
	
	private void deleteExample() {
		System.out.println("Before delete: " + repository.count());
        repository.deleteById(ID);
        System.out.println("After delete: " + repository.count());
		
	}

}
