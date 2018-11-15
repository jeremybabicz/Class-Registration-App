package edu.depaul.cdm.se.campusconnect.year.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import edu.depaul.cdm.se.campusconnect.year.jpa.Year;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("edu.depaul.cdm.se.campusconnect.year.mongo")
public class YearMain implements CommandLineRunner {
	@Autowired
	YearRepository repository;
	
	private static final Long ID = new Long(1);
	
	@Override
	public void run(String... args) throws Exception {
		/*createExample();
        updateExample();
        deleteExample();*/
	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(YearMain.class);
		app.run(args);

	}
	
	private void createExample() {
		System.out.println("Before create " + repository.count());
		Year year = new Year();
		year.setId(ID);
		year.setYearName("Freshman");
		
		repository.save(year);
		System.out.println("Year name is " + year.getYearName());
		System.out.println("After create " + repository.count());
		
	}
	
	private void updateExample() {
		Year year = repository.findById(ID).orElse(new Year());
		year.setYearName("Senior");
		repository.save(year);
		System.out.println("New year name is " + year.getYearName());
		
	}
	
	private void deleteExample() {
		System.out.println("Before delete: " + repository.count());
        repository.deleteById(ID);
        System.out.println("After delete: " + repository.count());
		
	}

}
