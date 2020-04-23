package com.zbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class GzmetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GzmetroApplication.class, args);
	}
	protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
