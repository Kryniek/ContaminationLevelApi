package pl.kryniek.contamination.level.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.kryniek.contamination.level.api.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

	@Query("SELECT m FROM Measurement m WHERE m.fromDateTime in :fromDateTimes")
	List<Measurement> findAllByFromDateTimes(@Param("fromDateTimes") List<Date> fromDateTimes);
}
