package pl.kryniek.contamination.level.api.ContaminationLevel.util.mapper;

import static pl.kryniek.contamination.level.api.ContaminationLevel.util.DateUtil.ofString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pl.kryniek.contamination.level.api.ContaminationLevel.enums.InstallationId;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Index;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.api.ApiIndex;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.api.ApiMeasurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;

public class MeasurementMapper {
	public static List<Measurement> apiToModel(List<ApiMeasurement> apiMeasurements, InstallationId installationId) {
		List<Measurement> measurements = new ArrayList<>();

		Optional<ApiMeasurement> apiMeasurementOptional = apiMeasurements.stream().findFirst();

		apiMeasurementOptional.ifPresent(apiMeasurement -> {
			apiMeasurement.getHistory().forEach(apiAveragedValue -> {
				Measurement measurement = new Measurement();
				measurement.setInstallationId(installationId.getId());
				measurement.setFromDateTime(ofString(apiAveragedValue.getFromDateTime()));
				measurement.setTillDateTime(ofString(apiAveragedValue.getTillDateTime()));

				apiAveragedValue.getValues().forEach(apiValue -> {
					BigDecimal value = apiValue.getValue();

					if (apiValue.isPm1()) {
						measurement.setPm1(value);
					} else if (apiValue.isPm25()) {
						measurement.setPm25(value);
					} else if (apiValue.isPm10()) {
						measurement.setPm10(value);
					} else if (apiValue.isPressure()) {
						measurement.setPressure(value);
					} else if (apiValue.isHumidity()) {
						measurement.setHumidity(value);
					} else if (apiValue.isTemperature()) {
						measurement.setTemperature(value);
					}
				});

				addIndexes(apiAveragedValue.getIndexes(), measurement);

				measurements.add(measurement);
			});
		});

		return measurements;
	}

	private static void addIndexes(List<ApiIndex> apiIndexes, Measurement measurement) {
		apiIndexes.forEach(apiIndex -> {
			Index index = new Index();
			index.setName(apiIndex.getName());
			index.setValue(apiIndex.getValue());
			index.setLevel(apiIndex.getLevel());
			index.setDescription(apiIndex.getDescription());
			index.setAdvice(apiIndex.getAdvice());
			index.setColor(apiIndex.getColor());

			measurement.getIndexes().add(index);
		});
	}

	public static List<Measurement> v1ToV2Model(List<V1Measurement> v1Measurements) {
		List<Measurement> measurements = new ArrayList<>();

		v1Measurements.forEach(v1Measurement -> {
			Measurement measurement = new Measurement();
			measurement.setInstallationId(v1Measurement.getSensorId());
			measurement.setFromDateTime(v1Measurement.getFromDateTime());
			measurement.setTillDateTime(v1Measurement.getTillDateTime());
			measurement.setInsertionDate(v1Measurement.getInsertionDate());
			measurement.setPm1(new BigDecimal(v1Measurement.getPm1()));
			measurement.setPm25(new BigDecimal(v1Measurement.getPm25()));
			measurement.setPm10(new BigDecimal(v1Measurement.getPm10()));
			measurement.setPressure(new BigDecimal(v1Measurement.getPressure()));
			measurement.setHumidity(new BigDecimal(v1Measurement.getHumidity()));
			measurement.setTemperature(new BigDecimal(v1Measurement.getTemperature()));

			measurements.add(measurement);
		});

		return measurements;
	}
}
