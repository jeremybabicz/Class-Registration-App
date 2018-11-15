package edu.depaul.cdm.se.campusconnect.major.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import edu.depaul.cdm.se.campusconnect.major.jpa.Major;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.campusconnect.major.mongo")
public class MajorMain implements CommandLineRunner {
	@Autowired
	MajorRepository repository;
	
	private static final Long ID = new Long(1);
	
	@Override
	public void run(String... args) throws Exception {
		/*createExample();
        updateExample();
        deleteExample();*/
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MajorMain.class);
		app.run(args);

	}
	
	private void createExample() {
		System.out.println("Before create " + repository.count());
		Major major = new Major();
		major.setId(ID);
		major.setMajorName("Computer Science");
		
		repository.save(major);
		System.out.println("Major name is " + major.getMajorName());
		System.out.println("After create " + repository.count());
		
	}
	
	private void updateExample() {
		Major major = repository.findById(ID).orElse(new Major());
		major.setMajorName("Law");
		repository.save(major);
		System.out.println("New major name is " + major.getMajorName());
		
	}
	
	private void deleteExample() {
		System.out.println("Before delete: " + repository.count());
        repository.deleteById(ID);
        System.out.println("After delete: " + repository.count());
		
	}

}
