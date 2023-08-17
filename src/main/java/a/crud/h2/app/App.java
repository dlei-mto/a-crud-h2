package a.crud.h2.app;

import java.time.Duration;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import a.crud.h2.app.dao.ARepo;
import a.crud.h2.app.model.Employee;

// @EnableR2dbcRepositories // spring.data.r2dbc.repositories.enabled=true
@SpringBootApplication
public class App {
	private Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner initData(ARepo repository) {

		return (args) -> {
			// save a few employees
			repository.saveAll(Arrays.asList(
					new Employee("Jerry", "Mouse", "jerry@eml.com"),
					new Employee("Ken", "James", "em@ail.com"),
					new Employee("David", "James", "em@ail.com")))
					.blockLast(Duration.ofSeconds(10));

			// fetch all employees
			log.info("Employees found with findAll():");
			log.info("-------------------------------");
			repository.findAll().doOnNext(employee -> {
				log.info(employee.toString());
			}).blockLast(Duration.ofSeconds(10));

			log.info("");

			// fetch an individual employee by ID
			repository.findById(1L).doOnNext(employee -> {
				log.info("Employee found with findById(1L):");
				log.info("--------------------------------");
				log.info(employee.toString());
				log.info("");
			}).block(Duration.ofSeconds(10));

			// fetch employees by last name
			log.info("Employee found with findByLastName('James'):");
			log.info("--------------------------------------------");
			repository.findByLastName("James").doOnNext(emp -> {
				log.info(emp.toString());
			}).blockLast(Duration.ofSeconds(10));
			log.info("");
		};
	}
}
