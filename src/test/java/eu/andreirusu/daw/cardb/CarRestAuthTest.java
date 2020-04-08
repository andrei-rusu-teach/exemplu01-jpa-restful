package eu.andreirusu.daw.cardb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CarRestAuthTest {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void givenAuthRequestOnPrivateService_shouldSucceedWith200()
			throws Exception {
		ResponseEntity<String> result = template.withBasicAuth("user", "user")
				.getForEntity("/api", String.class);
		assertThat(HttpStatus.OK.equals(result.getStatusCode()));
	}

}
