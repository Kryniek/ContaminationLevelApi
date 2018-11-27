package pl.kryniek.contamination.level.api.ContaminationLevel.util.responseEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.GET;

public class Response {
	public static ResponseEntity<Void> noContent() {
		return ResponseEntity.noContent().headers(getHeaders()).build();
	}

	public static <T> ResponseEntity<T> ok(T body) {
		return ResponseEntity.ok().headers(getHeaders()).body(body);
	}

	private static HttpHeaders getHeaders() {
		final String ACCESS_CONTROL_HEADERS = "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range";

		HttpHeaders headers = new HttpHeaders();
		headers.add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		headers.add(ACCESS_CONTROL_ALLOW_METHODS, GET.name());
		headers.add(ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_HEADERS);
		headers.add(ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_HEADERS);

		return headers;
	}
}
