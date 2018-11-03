package pl.kryniek.contamination.level.api.ContaminationLevel.model.api;

import java.util.ArrayList;
import java.util.List;

public class ApiAveragedValue {
	private String fromDateTime;
	private String tillDateTime;
	private List<ApiValue> values = new ArrayList<>();
	private List<ApiIndex> indexes = new ArrayList<>();
	private List<ApiStandard> standards = new ArrayList<>();

	public String getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public String getTillDateTime() {
		return tillDateTime;
	}

	public void setTillDateTime(String tillDateTime) {
		this.tillDateTime = tillDateTime;
	}

	public List<ApiValue> getValues() {
		return values;
	}

	public void setValues(List<ApiValue> values) {
		this.values = values;
	}

	public List<ApiIndex> getIndexes() {
		return indexes;
	}

	public void setIndexes(List<ApiIndex> indexes) {
		this.indexes = indexes;
	}

	public List<ApiStandard> getStandards() {
		return standards;
	}

	public void setStandards(List<ApiStandard> standards) {
		this.standards = standards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromDateTime == null) ? 0 : fromDateTime.hashCode());
		result = prime * result + ((indexes == null) ? 0 : indexes.hashCode());
		result = prime * result + ((standards == null) ? 0 : standards.hashCode());
		result = prime * result + ((tillDateTime == null) ? 0 : tillDateTime.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		ApiAveragedValue other = (ApiAveragedValue) obj;
		if (fromDateTime == null) {
			if (other.fromDateTime != null)
				return false;
		} else if (!fromDateTime.equals(other.fromDateTime))
			return false;
		if (indexes == null) {
			if (other.indexes != null)
				return false;
		} else if (!indexes.equals(other.indexes))
			return false;
		if (standards == null) {
			if (other.standards != null)
				return false;
		} else if (!standards.equals(other.standards))
			return false;
		if (tillDateTime == null) {
			if (other.tillDateTime != null)
				return false;
		} else if (!tillDateTime.equals(other.tillDateTime))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiAveragedValue [fromDateTime=" + fromDateTime + ", tillDateTime=" + tillDateTime + ", values="
				+ values + ", indexes=" + indexes + ", standards=" + standards + "]";
	}
}
