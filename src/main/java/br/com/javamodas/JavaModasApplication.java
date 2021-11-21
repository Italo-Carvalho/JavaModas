package br.com.javamodas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EntityScan(basePackages = {"br.com.javamodas.model"})
@EnableJpaRepositories(basePackages = {"br.com.javamodas.repository"})
@ComponentScan(basePackages = {"br.com.javamodas.service", "br.com.javamodas.controller", "br.com.javamodas.exception"})
@SpringBootApplication
@EnableOpenApi
public class JavaModasApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaModasApplication.class, args);
	}

}
