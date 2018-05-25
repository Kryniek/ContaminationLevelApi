package pl.kryniek.contamination.level.api.service.rest;

import static pl.kryniek.contamination.level.api.utils.JsonParserUtil.parseConnectionContentToMeasurementsBySensorId;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import pl.kryniek.contamination.level.api.definition.rest.AirlyApiRestService;
import pl.kryniek.contamination.level.api.enums.SensorId;
import pl.kryniek.contamination.level.api.model.Measurement;

@Service
public class AirlyApiRestServiceImpl implements AirlyApiRestService {

	private static final String BASIC_URL = "https://airapi.airly.eu/v1/";

	@Override
	public List<Measurement> getSensorMeasurementsBySensorId(SensorId sensorId) {
		final String URL = BASIC_URL + "sensor/measurements?sensorId=" + sensorId.getValue();

		return parseConnectionContentToMeasurementsBySensorId(getConnectionContentByUrl(URL), sensorId);
	}

	private Object getConnectionContentByUrl(String url) {
		final String API_KEY = "CLmbEMhlgB2S2sw5ugDds3wEAq7fN4cz";

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod(HttpMethod.GET.name());
			connection.setRequestProperty("apikey", API_KEY);
			connection.setRequestProperty("Accept", "application/json");

			Integer connectionResponseCode = connection.getResponseCode();

			if (!connectionResponseCode.equals(200)) {
				throw new RuntimeException(connectionResponseCode.toString());
			}

			return connection.getContent();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
