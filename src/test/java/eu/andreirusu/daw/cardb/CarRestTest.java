package eu.andreirusu.daw.cardb;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class CarRestTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAuthentication() throws Exception {
// Testing authentication with correct credentials
		this.mockMvc
				.perform(post("/login")
						.content("{\"username\":\"admin\", \"password\":\"admin\"}"))
				.andDo(print()).andExpect(status().isOk());
// Testing authentication with wrong credentials
		this.mockMvc
				.perform(post("/login")
						.content("{\"username\":\"admin\", \"password\":\"wrongpwd\"}"))
				.andDo(print()).andExpect(status().is4xxClientError());
	}

//	@Autowired
//	private WebApplicationContext context;
//
//	@Test
//	public void testcase1() {
//		MockMvcBuilders.webAppContextSetup(this.context)
//				.apply(SecurityMockMvcConfigurers.springSecurity()).build();
//		final MvcResult mvcResult = this.mvc
//				.perform(get("/").with(httpBasic("test1", "password"))).andDo(print())
//				.andExpect(status().isOk()).andReturn();
//	}

}
