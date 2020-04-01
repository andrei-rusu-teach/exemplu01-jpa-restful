package eu.andreirusu.daw.cardb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.andreirusu.daw.cardb.domain.Car;
import eu.andreirusu.daw.cardb.domain.CarRepository;

@SpringBootApplication
public class Daw07aApplication {

	@Autowired
	private CarRepository carRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(Daw07aApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Daw07aApplication.class, args);
		logger.info("\n ... Hello Spring Boot... (Andrei)...\n");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Place your code here
			logger
					.info("\n... Application started to INSERT VALUES into DB :) ...\n");
			// Save demo data to database
			carRepository
					.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000));
			carRepository
					.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
			carRepository
					.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000));
		};
	}
}
