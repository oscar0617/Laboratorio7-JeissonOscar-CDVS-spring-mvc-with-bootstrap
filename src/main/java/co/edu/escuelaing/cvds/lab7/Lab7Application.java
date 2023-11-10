package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab7Application {
	@Autowired
	ConfigurationService configurationService;

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			System.out.println("Adding Configurations....");
			configurationService.addConfiguration(new Configuration("premio", "810000"));
			configurationService.addConfiguration(new Configuration("descuento", "0.1"));
			configurationService.addConfiguration(new Configuration("app-name", "Miraculous: Las Aventuras de Ladybug"));

			System.out.println("\nGetting all configurations....");
			configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
