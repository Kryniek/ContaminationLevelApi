package pl.kryniek.contamination.level.api.ContaminationLevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.kryniek.contamination.level.api.ContaminationLevel.definition.MeasurementService;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;

import static pl.kryniek.contamination.level.api.ContaminationLevel.util.responseEntity.Response.*;

@RestController
@RequestMapping("api/measurements")
public class MeasurementController {

	@Autowired
	private MeasurementService service;

	@GetMapping("/{installationId}")
	public ResponseEntity<List<Measurement>> getByInstallationId(@PathVariable Integer installationId,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer records) {
		return ok(service.selectByInstallationId(installationId, page, records));
	}

	@PostMapping("/saveV1Measurements")
	public ResponseEntity<Void> saveV1Measurements(@RequestBody List<V1Measurement> v1Measurements) {
		service.saveV1Measurements(v1Measurements);

		return noContent();
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ok(service.count());
	}

	@GetMapping("/last")
	public ResponseEntity<Measurement> getLast() {
		return ok(service.selectLast());
	}
}
