package pl.kryniek.contamination.level.api.ContaminationLevel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kryniek.contamination.level.api.ContaminationLevel.definition.MeasurementService;
import pl.kryniek.contamination.level.api.ContaminationLevel.definition.rest.AirlyApiRestService;
import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.repository.MeasurementRepository;

import static pl.kryniek.contamination.level.api.ContaminationLevel.util.mapper.MeasurementMapper.v1ToV2Model;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementRepository repository;

	@Autowired
	private AirlyApiRestService airlyApiRestService;

	@Override
	public List<Measurement> selectAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void insertLast24HoursMeasurementsByInstallationId(InstallationId installationId) {
		List<Measurement> measurements = airlyApiRestService.getSensorMeasurementsByInstallationId(installationId);

		removeIncompleteAndExistingMeasurements(measurements, installationId);

		if (!isEmpty(measurements)) {
			repository.saveAll(measurements);
		}
	}

	private void removeIncompleteAndExistingMeasurements(List<Measurement> measurements,
			InstallationId installationId) {
		measurements.removeIf(measurement -> !measurement.areAllKeyFieldsNonNull());

		List<Date> fromDateTimes = measurements.stream().collect(mapping(Measurement::getFromDateTime, toList()));

		List<Measurement> existingMeasurements = repository.findByFromDateTimeInAndInstallationId(fromDateTimes,
				installationId.getId());

		existingMeasurements.forEach(existingMeasurement -> {
			measurements.removeIf(
					measurement -> existingMeasurement.getFromDateTime().compareTo(measurement.getFromDateTime()) == 0);
		});
	}

	@Override
	@Transactional
	public void saveV1Measurements(List<V1Measurement> v1Measurements) {
		repository.saveAll(v1ToV2Model(v1Measurements));
	}
}
