package br.com.arquitetura_web.pratica_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pratica3Application {

	public static void main(String[] args) {
		SpringApplication.run(Pratica3Application.class, args);
	}

}
