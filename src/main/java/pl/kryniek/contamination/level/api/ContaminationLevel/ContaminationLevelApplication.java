package pl.kryniek.contamination.level.api.ContaminationLevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ContaminationLevelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaminationLevelApplication.class, args);
	}
}
