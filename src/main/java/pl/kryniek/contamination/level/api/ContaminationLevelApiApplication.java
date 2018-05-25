package pl.kryniek.contamination.level.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContaminationLevelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaminationLevelApiApplication.class, args);
	}
}
