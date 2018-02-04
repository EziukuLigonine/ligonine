package lt.akademija.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import lt.akademija.Model.Prescription;

public interface PrescriptionRepository extends JpaRepository <Prescription, Long>{
	
	@Query("SELECT p FROM Prescription p WHERE " +
            "LOWER(p.patientId) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(p.doctorUsername) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Prescription> findByNameOrSurname(String search);

}
