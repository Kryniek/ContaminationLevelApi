package pl.kryniek.contamination.level.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kryniek.contamination.level.api.definition.MeasurementService;
import pl.kryniek.contamination.level.api.model.Measurement;

@RestController
@RequestMapping("api/measurements")
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;

	@GetMapping
	public List<Measurement> getAll() {
		return measurementService.selectAll();
	}
}
