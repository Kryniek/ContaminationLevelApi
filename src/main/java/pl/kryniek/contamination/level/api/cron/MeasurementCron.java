package pl.kryniek.contamination.level.api.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pl.kryniek.contamination.level.api.definition.MeasurementService;
import pl.kryniek.contamination.level.api.enums.SensorId;

@Component
public class MeasurementCron {

	@Autowired
	private MeasurementService measurementService;

	@Scheduled(cron = "${cron.scheduler.Measurement.insertForSensorIds}")
	public void insertForSensorIds() {
		for (SensorId sensorId : SensorId.values()) {
			measurementService.insertLast24HoursMeasurementsBySensorId(sensorId);
		}
	}
}
