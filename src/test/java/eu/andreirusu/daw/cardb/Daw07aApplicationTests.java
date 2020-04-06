package eu.andreirusu.daw.cardb;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.andreirusu.daw.cardb.web.CarController;

//@RunWith(SpringRunner.class)
@SpringBootTest
class Daw07aApplicationTests {
	@Autowired
	private CarController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
