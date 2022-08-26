package com.example.springsecurityallowswagger;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityAllowSwaggerApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void shouldAllowSwaggerRequestWithNoCredentials() throws Exception {
		this.mvc.perform(get("/swagger-ui/index")).andExpect(status().isOk()).andExpect(content().string("index"));
	}

	@Test
	void shouldReturnUnauthorizedForHomeWithNoCredentials() throws Exception {
		this.mvc.perform(get("/home")).andExpect(status().isUnauthorized());
	}

	@Test
	void shouldReturnOkForHomeWithCredentials() throws Exception {
		this.mvc.perform(get("/home").with(httpBasic("user", "password"))).andExpect(status().isOk()).andExpect(content().string("home"));
	}

}
