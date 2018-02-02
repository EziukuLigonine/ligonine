package lt.akademija.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String name;
	private String surname;
	private String birthday;
	private String personalId;
	private String username;
	private String password;
	private String doctorUsername;
	@ManyToOne
	private Doctor doctor;
	
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
  
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

  public String getPersonalId() {
		return personalId;
	}
	
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
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
	
	public String getDoctorUsername() {
		return doctorUsername;
	}
	
	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}
	
	@Override
    public String toString() {
        return String.valueOf(id);
    }

}
