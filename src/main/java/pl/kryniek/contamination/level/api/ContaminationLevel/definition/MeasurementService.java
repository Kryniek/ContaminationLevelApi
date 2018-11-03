package pl.kryniek.contamination.level.api.ContaminationLevel.definition;

import java.util.List;

import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;

public interface MeasurementService {
	List<Measurement> selectAll();

	void insertLast24HoursMeasurementsByInstallationId(InstallationId installationId);

	void saveV1Measurements(List<V1Measurement> mesurements);
}
