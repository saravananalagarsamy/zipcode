package com.wsgc.shipping;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ZipcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipcodeApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Shipping ZipCode Optimization API Gateway",
				"Shipping ZipCode Optimization API Gateway",
				"API 0.1",
				"Terms of service",
				new Contact("Saravanan", "https://github.com/saravananalagarsamy", "saravananalagarsamy@yahoo.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

}

