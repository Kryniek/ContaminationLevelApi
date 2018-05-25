package pl.kryniek.contamination.level.api.definition.rest;

import java.util.List;

import pl.kryniek.contamination.level.api.enums.SensorId;
import pl.kryniek.contamination.level.api.model.Measurement;

public interface AirlyApiRestService {

	List<Measurement> getSensorMeasurementsBySensorId(SensorId sensorId);
}
