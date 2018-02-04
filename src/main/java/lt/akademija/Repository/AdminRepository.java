package lt.akademija.Repository;

import java.util.List;
import lt.akademija.Model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository <Admin, Long>{
	
	@Query("SELECT a FROM Admin a WHERE " +
            "LOWER(a.name) LIKE LOWER(CONCAT('%',?1, '%')) OR " +
            "LOWER(a.surname) LIKE LOWER(CONCAT('%',?1, '%'))")
	List<Admin> findByNameOrSurname(String search);

}
