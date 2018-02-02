package lt.akademija.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lt.akademija.Model.CreateDoctorCmd;
import lt.akademija.Model.Doctor;
import lt.akademija.Model.Patient;
import lt.akademija.Repository.DoctorRepository;
import lt.akademija.Repository.PatientRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Transactional
	public List<Doctor> getDoctors(String search){
		return search == null ? doctorRepository.findAll() : doctorRepository.findByNameOrSurname(search);
	}
	
	@Transactional
	public Doctor getDoctor(@PathVariable String id) {
		return doctorRepository.getOne(Long.parseLong(id));
	}
	
	@Transactional
	public void createDoctor(@RequestBody CreateDoctorCmd cmd) {
		Doctor doctor = new Doctor();
		doctor.setName(cmd.getName());
		doctor.setSurname(cmd.getSurname());
		doctor.setSpecialisation(cmd.getSpecialisation());
		doctor.setUsername(cmd.getUsername());
		doctor.setPassword(cmd.getPassword());
		doctorRepository.save(doctor);
	}
	
	@Transactional
	public void updateDoctor(@RequestBody CreateDoctorCmd cmd, @PathVariable String id) {
		Doctor doctor = doctorRepository.getOne(Long.parseLong(id));
		if(doctor != null) {
			BeanUtils.copyProperties(cmd, doctor);
			doctorRepository.save(doctor);
		}
	}
	
	@Transactional
	public void deleteDoctor(@PathVariable String id) {
		doctorRepository.delete(Long.parseLong(id));
	}
	
	@Transactional
	public List<Patient> getDoctorPatients(String id){
		return patientRepository.findByDoctorUsername(doctorRepository.getOne(Long.parseLong(id)).getUsername());
		
	}

}
