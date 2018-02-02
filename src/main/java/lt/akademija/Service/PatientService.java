package lt.akademija.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lt.akademija.Model.CreatePatientCmd;
import lt.akademija.Model.Patient;
import lt.akademija.Repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Transactional
	public List<Patient> getPatients(String search) {
		return search == null ? patientRepository.findAll() : patientRepository.findByNameOrSurname(search);
	}

	@Transactional
	public Patient getPatient(@PathVariable String id) {
		return patientRepository.getOne(Long.parseLong(id));
	}

	@Transactional
	public void createPatient(@RequestBody CreatePatientCmd cmd) {
		Patient patient = new Patient();
		patient.setName(cmd.getName());
		patient.setSurname(cmd.getSurname());
		patient.setBirthday(cmd.getBirthday());
		patient.setPersonalId(cmd.getPersonalId());
		patient.setUsername(cmd.getUsername());
		patient.setPassword(cmd.getPassword());
		patientRepository.save(patient);
	}

	@Transactional
	public void updatePatient(@RequestBody CreatePatientCmd cmd, @PathVariable String id) {
		Patient patient = patientRepository.getOne(Long.parseLong(id));
		if (patient != null) {
			BeanUtils.copyProperties(cmd, patient);
			patientRepository.save(patient);
		}
	}

	@Transactional
	public void deletePatient(@PathVariable String id) {
		patientRepository.delete(Long.parseLong(id));
	}

}
