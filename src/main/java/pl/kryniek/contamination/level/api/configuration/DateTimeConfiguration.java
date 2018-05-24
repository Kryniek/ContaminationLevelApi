package pl.kryniek.contamination.level.api.configuration;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DateTimeConfiguration {

	@PostConstruct
	public void init() {
		final Integer SECOND = 1000;
		final Integer MINUTE = 60 * SECOND;
		final Integer HOUR = 60 * MINUTE;

		TimeZone timeZone = TimeZone.getDefault();
		timeZone.setRawOffset(3 * HOUR);

		TimeZone.setDefault(timeZone);
	}
}
