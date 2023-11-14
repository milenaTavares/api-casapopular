package com.casapopular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CasaPopularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaPopularApplication.class, args);
	}

}
