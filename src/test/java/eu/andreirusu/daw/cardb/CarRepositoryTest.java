package eu.andreirusu.daw.cardb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import eu.andreirusu.daw.cardb.domain.Car;
import eu.andreirusu.daw.cardb.domain.CarRepository;

@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CarRepository repository;

	@Test
	public void saveCar() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
		entityManager.persistAndFlush(car);
		assertThat(car.getId()).isNotNull();
	}

	@Test
	public void deleteCars() {
		entityManager.persistAndFlush(
				new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
		entityManager.persistAndFlush(
				new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500));
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}
//	Aici urmează să punem codul de testare

}
