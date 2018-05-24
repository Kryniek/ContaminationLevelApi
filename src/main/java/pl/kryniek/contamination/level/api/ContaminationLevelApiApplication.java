package pl.kryniek.contamination.level.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import pl.kryniek.contamination.level.api.configuration.DateTimeConfiguration;

@SpringBootApplication
@EnableJpaAuditing
@Import(DateTimeConfiguration.class)
public class ContaminationLevelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaminationLevelApiApplication.class, args);
	}
}
