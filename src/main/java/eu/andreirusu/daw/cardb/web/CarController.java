package eu.andreirusu.daw.cardb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.andreirusu.daw.cardb.domain.Car;
import eu.andreirusu.daw.cardb.domain.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository repository;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}
