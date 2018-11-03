package pl.kryniek.contamination.level.api.ContaminationLevel.util.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomJsonObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public CustomJsonObjectMapper() {
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
		this.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		this.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}
}
