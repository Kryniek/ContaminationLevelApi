package pl.kryniek.contamination.level.api.ContaminationLevel.model.api;

import java.math.BigDecimal;

public class ApiStandard {
	private String name;
	private String pollutant;
	private Integer limit;
	private BigDecimal percent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPollutant() {
		return pollutant;
	}

	public void setPollutant(String pollutant) {
		this.pollutant = pollutant;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limit == null) ? 0 : limit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
		result = prime * result + ((pollutant == null) ? 0 : pollutant.hashCode());
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
		ApiStandard other = (ApiStandard) obj;
		if (limit == null) {
			if (other.limit != null)
				return false;
		} else if (!limit.equals(other.limit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percent == null) {
			if (other.percent != null)
				return false;
		} else if (!percent.equals(other.percent))
			return false;
		if (pollutant == null) {
			if (other.pollutant != null)
				return false;
		} else if (!pollutant.equals(other.pollutant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiStandard [name=" + name + ", pollutant=" + pollutant + ", limit=" + limit + ", percent=" + percent
				+ "]";
	}
}
