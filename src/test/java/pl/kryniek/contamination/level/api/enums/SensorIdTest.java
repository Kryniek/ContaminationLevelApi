package pl.kryniek.contamination.level.api.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SensorIdTest {

	@Test
	public void parseShouldReturnSensorId_T1() {
		final SensorId WEJHEROWO_SENSOR_ID = SensorId.WEJHEROWO;
		SensorId sensorId = SensorId.parse(WEJHEROWO_SENSOR_ID.getValue());

		assertEquals(sensorId, WEJHEROWO_SENSOR_ID);
	}

	@Test(expected = RuntimeException.class)
	public void parseShouldThrowException_T2() {
		SensorId.parse(1);
	}
}
