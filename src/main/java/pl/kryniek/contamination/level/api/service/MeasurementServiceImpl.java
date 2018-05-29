package pl.kryniek.contamination.level.api.service;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kryniek.contamination.level.api.definition.MeasurementService;
import pl.kryniek.contamination.level.api.definition.rest.AirlyApiRestService;
import pl.kryniek.contamination.level.api.enums.SensorId;
import pl.kryniek.contamination.level.api.model.Measurement;
import pl.kryniek.contamination.level.api.repository.MeasurementRepository;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementRepository measurementRepository;

	@Autowired
	private AirlyApiRestService airlyApiRestService;

	@Override
	public List<Measurement> selectAll() {
		return measurementRepository.findAll();
	}

	@Override
	@Transactional
	public void insertLast24HoursMeasurementsBySensorId(SensorId sensorId) {
		List<Measurement> measurementsToInsert = airlyApiRestService.getSensorMeasurementsBySensorId(sensorId);

		removeMeasurementsIfExists(measurementsToInsert);

		if (!isEmpty(measurementsToInsert)) {
			insert(measurementsToInsert);
		}
	}

	private void removeMeasurementsIfExists(List<Measurement> measurementsToInsert) {
		List<Date> fromDateTimes = measurementsToInsert.stream().map(Measurement::getFromDateTime)
				.collect(Collectors.toList());

		List<Measurement> measurements = measurementRepository.findAllByFromDateTimes(fromDateTimes);

		measurements.forEach(measurement -> {
			measurementsToInsert.removeIf(measurementToInsert -> measurement.getFromDateTime()
					.compareTo(measurementToInsert.getFromDateTime()) == 0);
		});
	}

	private void insert(List<Measurement> measurements) {
		measurements.forEach(measurement -> insert(measurement));
	}

	private void insert(Measurement measurement) {
		measurementRepository.save(measurement);
	}
}
