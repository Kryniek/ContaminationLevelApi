package pl.kryniek.contamination.level.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import pl.kryniek.contamination.level.api.enums.SensorId;
import pl.kryniek.contamination.level.api.model.Measurement;

public class JsonParserUtil {
	public static List<Measurement> parseConnectionContentToMeasurementsBySensorId(Object connectionContent,
			SensorId sensorId) {
		List<Measurement> measurements = new ArrayList<Measurement>();

		try {
			JsonParser parser = new JsonFactory().createParser(new InputStreamReader((InputStream) connectionContent));

			Measurement measurement = new Measurement(sensorId.getValue());

			boolean isHistoryFieldOccurred = false;
			boolean isForecastFieldOccurred = false;

			while (!parser.isClosed()) {
				final String HISTORY_FIELD_NAME = "history";
				final String FORECAST_FIELD_NAME = "forecast";

				JsonToken token = parser.nextToken();

				if (HISTORY_FIELD_NAME.equals(parser.getCurrentName())) {
					isHistoryFieldOccurred = true;
				} else if (FORECAST_FIELD_NAME.equals(parser.getCurrentName())) {
					isForecastFieldOccurred = true;
				}

				if (JsonToken.FIELD_NAME.equals(token) && isHistoryFieldOccurred && !isForecastFieldOccurred) {
					measurement.setFieldByName(parser, token);

					if (measurement.areAllFieldsNonNull()) {
						measurements.add(measurement);
						measurement = new Measurement(sensorId.getValue());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return measurements;
	}
}
