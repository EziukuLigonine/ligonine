package lt.akademija.Model;

public class CreateDoctorCmd {
	
	private String name;
	private String surname;
	private String specialisation;
	private String username;
	private String password;
	
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

}
