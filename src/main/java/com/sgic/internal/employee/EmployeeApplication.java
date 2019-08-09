package com.sgic.internal.employee;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sgic.internal.employee.controller"))
				.paths(PathSelectors.ant("/*")).build().apiInfo(myDetails());

	}

	private ApiInfo myDetails() {
		return new ApiInfo("Employeeservice APIS", "Dev Details", "1.8", "",
				new springfox.documentation.service.Contact("ABC", "http://www.google.com", "abc@gmail.com"),
				"API License", "http://www.google.com", Collections.emptyList()

		);

	}

}