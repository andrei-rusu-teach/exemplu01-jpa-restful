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
import eu.andreirusu.daw.cardb.domain.Owner;
import eu.andreirusu.daw.cardb.domain.OwnerRepository;
import eu.andreirusu.daw.cardb.domain.Userr;
import eu.andreirusu.daw.cardb.domain.UserrRepository;

@SpringBootApplication
public class Daw07aApplication {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserrRepository userRepository;

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

			// Add owner objects and save these to db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			carRepository.save(
					new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			carRepository.save(
					new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018,
					39000, owner2));

			// username: user password: user
			userRepository.save(new Userr("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));
			// username: admin password: admin
			userRepository.save(new Userr("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"));
		};
	}
}
