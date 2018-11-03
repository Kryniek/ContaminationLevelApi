package pl.kryniek.contamination.level.api.ContaminationLevel.util;

import static java.time.ZoneId.systemDefault;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class DateUtil {
	private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public static Date ofString(String rawDate) {
		try {
			return DEFAULT_DATE_FORMAT.parse(rawDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date ofLocalDateTime(LocalDateTime localDateTime) {
		Optional<LocalDateTime> localDateOptional = Optional.ofNullable(localDateTime);

		if (localDateOptional.isPresent()) {
			return Date.from(localDateOptional.get().atZone(systemDefault()).toInstant());
		}

		return null;
	}
}