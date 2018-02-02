package lt.akademija.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.akademija.Model.Patient;

public interface PatientRepository  extends JpaRepository <Patient, Long> {
	
	@Query("SELECT pt FROM Patient pt WHERE " +
            "LOWER(pt.name) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(pt.surname) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Patient> findByNameOrSurname(String search);
	List<Patient> findByDoctorUsername(String search);

}
