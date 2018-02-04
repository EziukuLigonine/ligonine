package lt.akademija.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Record implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String patientId; // asmens kodas reik su pacientu sujungt
	@NotNull
	@Size(min=1, max=20)
	private String duration; // vizito laikas
	@NotNull
	@Size(min=1, max=20)
	private String tlk; // ICD-10/TLK10
	@NotNull
	@Size(min=1, max=200)
	private String appDesc; // vizito aprasas
	private String vlk; // kompensuojamas ar ne? bool?
	private String repeated; // pakartotinis? bool ar ne?
	private String doctorUsername; // israsiusio daktaro username. reikia su daktaru sujungt
	@NotNull
	@Size(min=3, max=20)
	private String date; // vizito data

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getVlk() {
		return vlk;
	}

	public void setVlk(String vlk) {
		this.vlk = vlk;
	}

	public String getTlk() {
		return tlk;
	}

	public void setTlk(String tlk) {
		this.tlk = tlk;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getRepeated() {
		return repeated;
	}

	public void setRepeated(String repeated) {
		this.repeated = repeated;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

}