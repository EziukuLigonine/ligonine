package lt.akademija.Model;

public class CreatePatientCmd {

	private String name;
	private String surname;
	private String birthday;
	private String personalId;
	private String username;
	private String password;
	private String doctorUsername;

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

}
