package edu.depaul.cdm.se.campusconnect.quarter.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import edu.depaul.cdm.se.campusconnect.quarter.jpa.Quarter;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.campusconnect.quarter.mongo")
public class QuarterMain implements CommandLineRunner {
	@Autowired
	QuarterRepository repository;
	
	private static final Long ID = new Long(1);
	
	@Override
	public void run(String... args) throws Exception {
		/*createExample();
        updateExample();
        deleteExample();*/
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(QuarterMain.class);
		app.run(args);

	}
	
	private void createExample() {
		System.out.println("Before create " + repository.count());
		Quarter quarter = new Quarter();
		quarter.setId(ID);
		quarter.setQuarterName("Spring");
		
		repository.save(quarter);
		System.out.println("Quarter name is " + quarter.getQuarterName());
		System.out.println("After create " + repository.count());
		
	}
	
	private void updateExample() {
		Quarter quarter = repository.findById(ID).orElse(new Quarter());
		quarter.setQuarterName("Fall");
		repository.save(quarter);
		System.out.println("New quarter name is " + quarter.getQuarterName());
		
	}
	
	private void deleteExample() {
		System.out.println("Before delete: " + repository.count());
        repository.deleteById(ID);
        System.out.println("After delete: " + repository.count());
		
	}
	
	

}
