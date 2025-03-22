package br.com.tokiomarine.seguradora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class ProvaTokioApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProvaTokioApplication.class, args);
	}
}
