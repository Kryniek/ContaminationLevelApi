package pl.kryniek.contamination.level.api.ContaminationLevel.model.api;

import java.util.List;

public class ApiMeasurement {
	private ApiAveragedValue current;
	private List<ApiAveragedValue> history;
	private List<ApiAveragedValue> forecast;

	public ApiAveragedValue getCurrent() {
		return current;
	}

	public void setCurrent(ApiAveragedValue current) {
		this.current = current;
	}

	public List<ApiAveragedValue> getHistory() {
		return history;
	}

	public void setHistory(List<ApiAveragedValue> history) {
		this.history = history;
	}

	public List<ApiAveragedValue> getForecast() {
		return forecast;
	}

	public void setForecast(List<ApiAveragedValue> forecast) {
		this.forecast = forecast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current == null) ? 0 : current.hashCode());
		result = prime * result + ((forecast == null) ? 0 : forecast.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
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
		ApiMeasurement other = (ApiMeasurement) obj;
		if (current == null) {
			if (other.current != null)
				return false;
		} else if (!current.equals(other.current))
			return false;
		if (forecast == null) {
			if (other.forecast != null)
				return false;
		} else if (!forecast.equals(other.forecast))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiMeasurement [current=" + current + ", history=" + history + ", forecast=" + forecast + "]";
	}
}
