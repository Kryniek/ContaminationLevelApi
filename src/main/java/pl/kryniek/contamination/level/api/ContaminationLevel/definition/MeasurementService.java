package pl.kryniek.contamination.level.api.ContaminationLevel.definition;

import java.util.List;

import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;

public interface MeasurementService {
	List<Measurement> selectByInstallationId(Integer installationId, Integer page, Integer records);

	void insertLast24HoursMeasurementsByInstallationId(InstallationId installationId);

	void saveV1Measurements(List<V1Measurement> mesurements);

	Long count();

	Measurement selectLast();
}
