package edu.depaul.cdm.se.campusconnect.classpackage.spring;


import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.transaction.annotation.Transactional;

//import javax.persistence.EntityTransaction;
//import java.util.List;

//@Transactional
//@TestConfiguration
@SpringBootApplication
@EnableJpaAuditing
@EntityScan({"edu.depaul.cdm.se.campusconnect.classpackage.jpa", "edu.depaul.cdm.se.campusconnect.student.jpa"})
@ComponentScan("edu.depaul.cdm.se.campusconnect.classpackage.spring")
public class ClassMain implements CommandLineRunner {
	@Autowired
	ClassRepository repository;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ClassMain.class);
        app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*createExample();
		updateExample();
		deleteExample();*/
	}
	
	private void createExample() {
        System.out.println(repository.count());
        Class classObj = new Class();
        classObj.setCourseName("Enterprise Dev");

        repository.save(classObj);
        System.out.println(classObj.getCourseName());
        System.out.println(repository.count());
    }
	
	private void updateExample() {
		Class classObj = repository.getOne(new Long(1));
		
		classObj.setCourseName(classObj.getCourseName() + " add");
		repository.save(classObj);
        classObj = new Class();
        System.out.println(classObj.getCourseName());
        classObj = repository.getOne(new Long(1));
        System.out.println("New name = " + classObj.getCourseName());
    }
	
    private void deleteExample() {
        System.out.println("Before delete: " + repository.count());
        repository.deleteById(new Long(1));
        System.out.println("After delete: " + repository.count());
    }
}
