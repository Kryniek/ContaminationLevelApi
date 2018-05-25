package pl.kryniek.contamination.level.api.definition;

import java.util.List;

import pl.kryniek.contamination.level.api.enums.SensorId;
import pl.kryniek.contamination.level.api.model.Measurement;

public interface MeasurementService {

	List<Measurement> selectAll();

	void insertLast24HoursMeasurementsBySensorId(SensorId sensorId);
}
