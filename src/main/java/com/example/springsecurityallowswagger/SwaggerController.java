package com.example.springsecurityallowswagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to mock the swagger URL
 */
@RestController
@RequestMapping("/swagger-ui")
public class SwaggerController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
