package org.academiadecodigo.hackathon.allchildrenmatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
//@EnableWebMvc
public class AllChildrenMatterApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(AllChildrenMatterApplication.class, args);
	}

}
