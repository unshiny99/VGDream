package com.insa.VGDream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@SpringBootApplication
public class VgDreamApplication {
	@RequestMapping ( "/")
	public RedirectView redirectView(){
		return new RedirectView("/home.html");
	}

	public static void main(String[] args) {
		SpringApplication.run(VgDreamApplication.class, args);
	}

}
