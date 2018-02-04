package lt.akademija.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.CreatePatientCmd;
import lt.akademija.Model.Patient;
import lt.akademija.Service.PatientService;

@RestController
@Api(value = "Patient")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(value = "/patients")
	@ApiOperation(value = "Get list of all patients", notes = "Returns list of all patients")
	public List<Patient> getPatients(@ApiParam(value = "Search patient")
										@RequestParam(value = "search", required = false) String search ) {
		return patientService.getPatients(search);
	}
	
	@GetMapping(value = {"/patients/{id}", "/admin/patients/{id}"})
	@ApiOperation(value = "Get patient", notes = "Returns patient by id")
	public Patient getPatient(@PathVariable String id) {
		return patientService.getPatient(id);
	}
	
	@PostMapping(value = "/admin/patients/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create patient", notes = "Creates patient user")
	public void createPatient(@RequestBody CreatePatientCmd cmd) {
		patientService.createPatient(cmd);
	}
	
	@PutMapping(value = "/admin/patients/{id}")
	@ApiOperation(value = "Update patient", notes = "Updates patient user details")
	public void updatePatient(@RequestBody CreatePatientCmd cmd, @PathVariable String id) {
		patientService.updatePatient(cmd, id);
	}
	
	@DeleteMapping(value = "/admin/patients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete patient", notes = "Deletes patient user")
	public void deletePatient(@PathVariable String id) {
		patientService.deletePatient(id);
	}

}
