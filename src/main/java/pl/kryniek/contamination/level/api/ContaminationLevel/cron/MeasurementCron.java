package pl.kryniek.contamination.level.api.ContaminationLevel.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pl.kryniek.contamination.level.api.ContaminationLevel.definition.MeasurementService;
import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;

@Component
public class MeasurementCron {

	@Autowired
	private MeasurementService measurementService;

//	@Scheduled(cron = "${cron.scheduler.Measurement.insertForSensorIds}")
	public void insertForSensorIds() {
		for (InstallationId installationId : InstallationId.values()) {
			measurementService.insertLast24HoursMeasurementsByInstallationId(installationId);
		}
	}
}
