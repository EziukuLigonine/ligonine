package lt.akademija.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.akademija.Model.Pharmacist;

public interface PharmacistRepository  extends JpaRepository <Pharmacist, Long> {
	
	@Query("SELECT p FROM Pharmacist p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(p.surname) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Pharmacist> findByNameOrSurname(String search);

}
