package pl.kryniek.contamination.level.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kryniek.contamination.level.api.definition.MeasurementService;
import pl.kryniek.contamination.level.api.model.Measurement;
import pl.kryniek.contamination.level.api.repository.MeasurementRepository;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementRepository measurementRepository;

	@Override
	public List<Measurement> selectAll() {
		return measurementRepository.findAll();
	}

	@Override
	public void insert(Measurement measurement) {
		measurementRepository.save(measurement);
	}
}
