package lt.akademija.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import lt.akademija.Model.Doctor;

public interface DoctorRepository extends JpaRepository <Doctor, Long>{
	
	@Query("SELECT d FROM Doctor d WHERE " +
            "LOWER(d.name) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(d.surname) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Doctor> findByNameOrSurname(String search);
	List<Doctor> findById(String id);

}
