package pl.kryniek.contamination.level.api.ContaminationLevel.model;

import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;
import static pl.kryniek.contamination.level.api.ContaminationLevel.util.DateUtil.ofLocalDateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "measurements")
public class Measurement {

	@Id
	private String id;

	@Indexed
	@NotNull(message = "installationId is null")
	private Integer installationId;

	@Indexed
	@NotNull(message = "fromDateTime is null")
	private Date fromDateTime;

	@Indexed
	@NotNull(message = "tillDateTime is null")
	private Date tillDateTime;

	@NotNull(message = "insertionDate is null")
	private Date insertionDate = ofLocalDateTime(now());

	@NotNull(message = "pm1 is null")
	private BigDecimal pm1;

	@NotNull(message = "pm25 is null")
	private BigDecimal pm25;

	@NotNull(message = "pm10 is null")
	private BigDecimal pm10;

	@NotNull(message = "pressure is null")
	private BigDecimal pressure;

	@NotNull(message = "humidity is null")
	private BigDecimal humidity;

	@NotNull(message = "temperature is null")
	private BigDecimal temperature;

	@NotNull(message = "indexes are null")
	private List<Index> indexes = new ArrayList<>();

	public boolean areAllKeyFieldsNonNull() {
		return nonNull(installationId) && nonNull(fromDateTime) && nonNull(tillDateTime) && nonNull(insertionDate)
				&& nonNull(pm1) && nonNull(pm25) && nonNull(pm10) && nonNull(pressure) && nonNull(humidity)
				&& nonNull(temperature);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getInstallationId() {
		return installationId;
	}

	public void setInstallationId(Integer installationId) {
		this.installationId = installationId;
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

	public BigDecimal getPm1() {
		return pm1;
	}

	public void setPm1(BigDecimal pm1) {
		this.pm1 = pm1;
	}

	public BigDecimal getPm25() {
		return pm25;
	}

	public void setPm25(BigDecimal pm25) {
		this.pm25 = pm25;
	}

	public BigDecimal getPm10() {
		return pm10;
	}

	public void setPm10(BigDecimal pm10) {
		this.pm10 = pm10;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public List<Index> getIndexes() {
		return indexes;
	}

	public void setIndexes(List<Index> indexes) {
		this.indexes = indexes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromDateTime == null) ? 0 : fromDateTime.hashCode());
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((indexes == null) ? 0 : indexes.hashCode());
		result = prime * result + ((insertionDate == null) ? 0 : insertionDate.hashCode());
		result = prime * result + ((installationId == null) ? 0 : installationId.hashCode());
		result = prime * result + ((pm1 == null) ? 0 : pm1.hashCode());
		result = prime * result + ((pm10 == null) ? 0 : pm10.hashCode());
		result = prime * result + ((pm25 == null) ? 0 : pm25.hashCode());
		result = prime * result + ((pressure == null) ? 0 : pressure.hashCode());
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
		if (indexes == null) {
			if (other.indexes != null)
				return false;
		} else if (!indexes.equals(other.indexes))
			return false;
		if (insertionDate == null) {
			if (other.insertionDate != null)
				return false;
		} else if (!insertionDate.equals(other.insertionDate))
			return false;
		if (installationId == null) {
			if (other.installationId != null)
				return false;
		} else if (!installationId.equals(other.installationId))
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
		if (pressure == null) {
			if (other.pressure != null)
				return false;
		} else if (!pressure.equals(other.pressure))
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
		return "Measurement [id=" + id + ", installationId=" + installationId + ", fromDateTime=" + fromDateTime
				+ ", tillDateTime=" + tillDateTime + ", insertionDate=" + insertionDate + ", pm1=" + pm1 + ", pm25="
				+ pm25 + ", pm10=" + pm10 + ", pressure=" + pressure + ", humidity=" + humidity + ", temperature="
				+ temperature + ", indexes=" + indexes + "]";
	}
}
