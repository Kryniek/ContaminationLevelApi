package pl.kryniek.contamination.level.api.ContaminationLevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kryniek.contamination.level.api.ContaminationLevel.definition.MeasurementService;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.Measurement;
import pl.kryniek.contamination.level.api.ContaminationLevel.model.v1.V1Measurement;

@RestController
@RequestMapping("api/measurements")
public class MeasurementController {

	@Autowired
	private MeasurementService service;

	@GetMapping
	public ResponseEntity<List<Measurement>> getAll() {
		return new ResponseEntity<List<Measurement>>(service.selectAll(), HttpStatus.OK);
	}

	@PostMapping("/saveV1Measurements")
	public ResponseEntity<Void> saveV1Measurements(@RequestBody List<V1Measurement> v1Measurements) {
		service.saveV1Measurements(v1Measurements);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return new ResponseEntity<Long>(service.count(), HttpStatus.OK);
	}

	@GetMapping("/last")
	public ResponseEntity<Measurement> getLast() {
		return new ResponseEntity<Measurement>(service.getLast(), HttpStatus.OK);
	}
}
