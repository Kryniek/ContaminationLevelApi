package pl.kryniek.contamination.level.api.ContaminationLevel.definition.rest;

import java.util.List;

import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;

public interface AirlyApiRestService {
	List<Measurement> getSensorMeasurementsByInstallationId(InstallationId installationId);
}
