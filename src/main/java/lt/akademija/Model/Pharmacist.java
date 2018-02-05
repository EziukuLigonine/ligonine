package lt.akademija.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pharmacist implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@NotNull
	@Size(min=3, max=20)
	@Pattern(regexp ="[a-zA-Z]+")
	private String name;
	@NotNull
	@Size(min=3, max=20)
	@Pattern(regexp ="[a-zA-Z]+")
	private String surname;
	@NotNull
	@Size(min=3, max=20)
    @Pattern(regexp = "\\w")
	private String companyType;
	@NotNull
	@Size(min=3, max=20)
    @Pattern(regexp = "\\w")
	private String companyName;
	@NotNull
	@Size(min=3, max=20)
	@Pattern(regexp = "\\w")
	private String username;
	@NotNull
	@Size(min=6, max=20)
	private String password;
	
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
	
	public String getCompanyType() {
		return companyType;
	}
	
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
