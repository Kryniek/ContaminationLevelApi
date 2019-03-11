package pl.kryniek.contamination.level.api.ContaminationLevel.util.responseEntity;

import org.springframework.http.ResponseEntity;

public class Response {
	public static ResponseEntity<Void> noContent() {
		return ResponseEntity.noContent().build();
	}

	public static <T> ResponseEntity<T> ok(T body) {
		return ResponseEntity.ok().body(body);
	}
}
