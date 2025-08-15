package Desafio.Foro_Hub_G8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"Desafio.Foro_Hub_G8.infra.seguridad", "Desafio.Foro_Hub_G8"})
public class ForoHubG8Application {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubG8Application.class, args);
	}
}