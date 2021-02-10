package fr.epsi.apiweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration("application.properties")
public class ApiWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApiWebApplication.class, args);
	}

}
