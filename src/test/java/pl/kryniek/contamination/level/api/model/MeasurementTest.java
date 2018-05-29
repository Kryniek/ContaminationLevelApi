package pl.kryniek.contamination.level.api.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class MeasurementTest {

	@Test
	public void areAllFieldsNonNullShouldReturnTrue_T1() {
		Measurement measurementExpected = getMeasurementForT1();

		assertTrue(measurementExpected.areAllFieldsNonNull());
	}

	@Test
	public void areAllFieldsNonNullShouldReturnFalse_T2() {
		assertFalse(new Measurement().areAllFieldsNonNull());
	}

	private Measurement getMeasurementForT1() {
		Measurement measurement = new Measurement();
		measurement.setSensorId(1);
		measurement.setAirQualityIndex(1.0);
		measurement.setHumidity(1.0);
		measurement.setPm1(1.0);
		measurement.setPm25(1.0);
		measurement.setPm10(1.0);
		measurement.setPressure(1.0);
		measurement.setTemperature(1.0);
		measurement.setPollutionLevel(1);
		measurement.setFromDateTime(new Date());
		measurement.setTillDateTime(new Date());

		return measurement;
	}
}
