package pl.kryniek.contamination.level.api.ContaminationLevel.service;

import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
import static java.util.Objects.isNull;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementRepository repository;

	@Autowired
	private AirlyApiRestService airlyApiRestService;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Measurement> selectByInstallationId(Integer installationId, Integer page, Integer records) {
		if (isNull(installationId)) {
			throw new RuntimeException("Installation id has not been provided.");
		}

		Query query = new Query();
		query.limit(records);
		query.addCriteria(Criteria.where("installationId").is(installationId));
		query.with(new Sort(Sort.Direction.DESC, "id"));

		if (!page.equals(1)) {
			query.skip((page - 1) * records);
		}

		List<Measurement> measurements = mongoTemplate.find(query, Measurement.class);

		addScaleToBigDecimalFields(measurements);

		return measurements;
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

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Measurement selectLast() {
		Query query = new Query();
		query.limit(1).with(new Sort(Sort.Direction.DESC, "id"));

		Measurement lastMeasurement = mongoTemplate.findOne(query, Measurement.class);

		addScaleToBigDecimalFields(lastMeasurement);

		return lastMeasurement;
	}

	private void addScaleToBigDecimalFields(List<Measurement> measurements) {
		measurements.forEach(measurement -> addScaleToBigDecimalFields(measurement));
	}

	private void addScaleToBigDecimalFields(Measurement measurement) {
		measurement.setPm1(measurement.getPm1().setScale(2, RoundingMode.HALF_DOWN));
		measurement.setPm25(measurement.getPm25().setScale(2, RoundingMode.HALF_DOWN));
		measurement.setPm10(measurement.getPm10().setScale(2, RoundingMode.HALF_DOWN));
		measurement.setPressure(measurement.getPressure().setScale(2, RoundingMode.HALF_DOWN));
		measurement.setHumidity(measurement.getHumidity().setScale(2, RoundingMode.HALF_DOWN));
		measurement.setTemperature(measurement.getTemperature().setScale(2, RoundingMode.HALF_DOWN));
	}
}
