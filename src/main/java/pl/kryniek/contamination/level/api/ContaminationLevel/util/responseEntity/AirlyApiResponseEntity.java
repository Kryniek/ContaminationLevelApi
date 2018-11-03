package pl.kryniek.contamination.level.api.ContaminationLevel.util.responseEntity;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.api.ApiMeasurement;

import static pl.kryniek.contamination.level.api.ContaminationLevel.util.mapper.MeasurementMapper.apiToModel;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AirlyApiResponseEntity {

	private static final String BASIC_URL = "https://airapi.airly.eu/v2/";
	private static final String API_KEY = "CLmbEMhlgB2S2sw5ugDds3wEAq7fN4cz";

	private HttpMethod httpMethod;
	private HttpHeaders basicHttpHeaders;

	private RestTemplate restTemplate;

	public AirlyApiResponseEntity(HttpMethod httpMethod, RestTemplate restTemplate) {
		this.httpMethod = httpMethod;
		this.restTemplate = restTemplate;

		setBasicHttpHeaders();
	}

	private void setBasicHttpHeaders() {
		basicHttpHeaders = new HttpHeaders();
		basicHttpHeaders.set("apikey", API_KEY);
		basicHttpHeaders.set(HttpHeaders.ACCEPT_LANGUAGE, "pl");
	}

	public List<Measurement> getSensorMeasurementsByInstallationId(InstallationId installationId) {
		final String URL = BASIC_URL + "measurements/installation?installationId=" + installationId.getId();

		ResponseEntity<List<ApiMeasurement>> responseEntity = restTemplate.exchange(URL, httpMethod,
				new HttpEntity(basicHttpHeaders), new ParameterizedTypeReference<List<ApiMeasurement>>() {
				});

		return apiToModel(responseEntity.getBody(), installationId);
	}
}
