package pl.myprojects.project2.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	private final String[] list = {"Spring Boot", "Spring Security", "Thymeleaf", "Maven", "HTML", "CSS", "JavaScript", "Bootstrap"};
	
	@GetMapping("/")
	public String def() {
		return "/home";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/about")
	public String about(Map<String, Object> model) {
		model.put("technologies", this.list);
		return "/about";
	}

	@GetMapping("/dog")
	public String man() {
		return "/dog";
	}
	
	@GetMapping("/cat")
	public String woman() {
		return "/cat";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/error403")
	public String error403() {
		return "/error403";
	}
}
