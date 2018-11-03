package pl.kryniek.contamination.level.api.ContaminationLevel.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.kryniek.contamination.level.api.ContaminationLevel.definition.rest.AirlyApiRestService;
import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.util.responseEntity.AirlyApiResponseEntity;

@Service
public class AirlyApiRestServiceImpl implements AirlyApiRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Measurement> getSensorMeasurementsByInstallationId(InstallationId installationId) {
		return new AirlyApiResponseEntity(HttpMethod.GET, restTemplate).getSensorMeasurementsByInstallationId(installationId);
	}
}
