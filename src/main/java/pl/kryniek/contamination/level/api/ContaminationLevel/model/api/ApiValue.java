package pl.kryniek.contamination.level.api.ContaminationLevel.model.api;

import java.math.BigDecimal;

public class ApiValue {
	private String name;
	private BigDecimal value;

	public enum Name {
		PM1, PM25, PM10, PRESSURE, HUMIDITY, TEMPERATURE;
	}

	public boolean isPm1() {
		return Name.PM1.name().equals(name);
	}

	public boolean isPm25() {
		return Name.PM25.name().equals(name);
	}

	public boolean isPm10() {
		return Name.PM10.name().equals(name);
	}

	public boolean isPressure() {
		return Name.PRESSURE.name().equals(name);
	}

	public boolean isHumidity() {
		return Name.HUMIDITY.name().equals(name);
	}

	public boolean isTemperature() {
		return Name.TEMPERATURE.name().equals(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiValue other = (ApiValue) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiValue [name=" + name + ", value=" + value + "]";
	}
}
