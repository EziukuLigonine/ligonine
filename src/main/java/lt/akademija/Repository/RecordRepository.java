package lt.akademija.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.akademija.Model.Record;

public interface RecordRepository extends JpaRepository <Record, Long>{
	
	@Query("SELECT r FROM Record r WHERE " +
            "LOWER(r.patientId) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(r.doctorUsername) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Record> findByNameOrSurname(String search);

}
