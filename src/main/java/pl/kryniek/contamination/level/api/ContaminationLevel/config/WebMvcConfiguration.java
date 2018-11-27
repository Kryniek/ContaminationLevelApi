package pl.kryniek.contamination.level.api.ContaminationLevel.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.kryniek.contamination.level.api.ContaminationLevel.util.jackson.CustomJsonObjectMapper;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(mappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);

		return restTemplate;
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setObjectMapper(objectMapper());

		return jsonConverter;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new CustomJsonObjectMapper();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());

		super.addDefaultHttpMessageConverters(converters);
	}
}
