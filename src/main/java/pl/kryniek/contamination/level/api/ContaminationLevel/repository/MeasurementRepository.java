package pl.kryniek.contamination.level.api.ContaminationLevel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;

public interface MeasurementRepository extends MongoRepository<Measurement, String> {

	List<Measurement> findByFromDateTimeInAndInstallationId(List<Date> fromDateTimes, Integer installationId);
}
