package pl.kryniek.contamination.level.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.kryniek.contamination.level.api.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
