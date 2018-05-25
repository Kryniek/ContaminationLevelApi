package pl.kryniek.contamination.level.api.enums;

import static java.util.Objects.isNull;

public enum SensorId {
	WEJHEROWO(3351);

	private Integer value;

	private SensorId(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static SensorId parse(Integer value) {
		if (isNull(value) || Integer.compare(value.intValue(), 0) <= 0) {
			return null;
		}

		for (SensorId sensorId : SensorId.values()) {
			if (sensorId.value.equals(value)) {
				return sensorId;
			}
		}

		throw new RuntimeException("Cannot parse SensorId with value: " + value + ".");
	}
}
