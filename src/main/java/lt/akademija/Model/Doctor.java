package lt.akademija.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@Size(min=2, max=30)
	private String name;
    @NotNull
    @Size(min=3, max=20)
	private String surname;
    @NotNull
    @Size(min=3, max=30)
	private String specialisation;
    @NotNull
    @Size(min=3, max=20)
	private String username;
    @NotNull
    @Size(min=6, max=30)
	private String password;
	@OneToMany(mappedBy = "doctor")
	private List<Patient> patients;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSpecialisation() {
		return specialisation;
	}
	
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public String toString() {
        return String.valueOf(id);
    }

}
