package pl.kryniek.contamination.level.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "measurement")
@EntityListeners(AuditingEntityListener.class)
public class Measurement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "sensorId is null")
	private Integer sensorId;

	@NotNull(message = "airQualityIndex is null")
	private Integer airQualityIndex;

	@NotNull(message = "humidity is null")
	private Integer humidity;

	@NotNull(message = "pm1 is null")
	private Integer pm1;

	@NotNull(message = "pm25 is null")
	private Integer pm25;

	@NotNull(message = "pm10 is null")
	private Integer pm10;

	@NotNull(message = "pressure is null")
	private Integer pressure;

	@NotNull(message = "temperature is null")
	private Integer temperature;

	@NotNull(message = "pollutionLevel is null")
	private Integer pollutionLevel;

	@NotNull(message = "fromDateTime is null")
	private Date fromDateTime;

	@NotNull(message = "tillDateTime is null")
	private Date tillDateTime;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date insertionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSensorId() {
		return sensorId;
	}

	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}

	public Integer getAirQualityIndex() {
		return airQualityIndex;
	}

	public void setAirQualityIndex(Integer airQualityIndex) {
		this.airQualityIndex = airQualityIndex;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Integer getPm1() {
		return pm1;
	}

	public void setPm1(Integer pm1) {
		this.pm1 = pm1;
	}

	public Integer getPm25() {
		return pm25;
	}

	public void setPm25(Integer pm25) {
		this.pm25 = pm25;
	}

	public Integer getPm10() {
		return pm10;
	}

	public void setPm10(Integer pm10) {
		this.pm10 = pm10;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Integer getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(Integer pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}

	public Date getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(Date fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public Date getTillDateTime() {
		return tillDateTime;
	}

	public void setTillDateTime(Date tillDateTime) {
		this.tillDateTime = tillDateTime;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airQualityIndex == null) ? 0 : airQualityIndex.hashCode());
		result = prime * result + ((fromDateTime == null) ? 0 : fromDateTime.hashCode());
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insertionDate == null) ? 0 : insertionDate.hashCode());
		result = prime * result + ((pm1 == null) ? 0 : pm1.hashCode());
		result = prime * result + ((pm10 == null) ? 0 : pm10.hashCode());
		result = prime * result + ((pm25 == null) ? 0 : pm25.hashCode());
		result = prime * result + ((pollutionLevel == null) ? 0 : pollutionLevel.hashCode());
		result = prime * result + ((pressure == null) ? 0 : pressure.hashCode());
		result = prime * result + ((sensorId == null) ? 0 : sensorId.hashCode());
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
		result = prime * result + ((tillDateTime == null) ? 0 : tillDateTime.hashCode());
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
		Measurement other = (Measurement) obj;
		if (airQualityIndex == null) {
			if (other.airQualityIndex != null)
				return false;
		} else if (!airQualityIndex.equals(other.airQualityIndex))
			return false;
		if (fromDateTime == null) {
			if (other.fromDateTime != null)
				return false;
		} else if (!fromDateTime.equals(other.fromDateTime))
			return false;
		if (humidity == null) {
			if (other.humidity != null)
				return false;
		} else if (!humidity.equals(other.humidity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insertionDate == null) {
			if (other.insertionDate != null)
				return false;
		} else if (!insertionDate.equals(other.insertionDate))
			return false;
		if (pm1 == null) {
			if (other.pm1 != null)
				return false;
		} else if (!pm1.equals(other.pm1))
			return false;
		if (pm10 == null) {
			if (other.pm10 != null)
				return false;
		} else if (!pm10.equals(other.pm10))
			return false;
		if (pm25 == null) {
			if (other.pm25 != null)
				return false;
		} else if (!pm25.equals(other.pm25))
			return false;
		if (pollutionLevel == null) {
			if (other.pollutionLevel != null)
				return false;
		} else if (!pollutionLevel.equals(other.pollutionLevel))
			return false;
		if (pressure == null) {
			if (other.pressure != null)
				return false;
		} else if (!pressure.equals(other.pressure))
			return false;
		if (sensorId == null) {
			if (other.sensorId != null)
				return false;
		} else if (!sensorId.equals(other.sensorId))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		if (tillDateTime == null) {
			if (other.tillDateTime != null)
				return false;
		} else if (!tillDateTime.equals(other.tillDateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Measurement [id=" + id + ", sensorId=" + sensorId + ", airQualityIndex=" + airQualityIndex
				+ ", humidity=" + humidity + ", pm1=" + pm1 + ", pm25=" + pm25 + ", pm10=" + pm10 + ", pressure="
				+ pressure + ", temperature=" + temperature + ", pollutionLevel=" + pollutionLevel + ", fromDateTime="
				+ fromDateTime + ", tillDateTime=" + tillDateTime + ", insertionDate=" + insertionDate + "]";
	}
}
