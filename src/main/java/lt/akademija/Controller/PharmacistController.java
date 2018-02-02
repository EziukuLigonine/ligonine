package lt.akademija.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademija.Model.CreatePharmacistCmd;
import lt.akademija.Model.Pharmacist;
import lt.akademija.Service.PharmacistService;

@RestController
@Api(value = "Pharmacist")
@RequestMapping(value = "/api")
public class PharmacistController {
	
	@Autowired
	private PharmacistService pharmacistService;
	
	@GetMapping(value = "/pharmacists")
	@ApiOperation(value = "Get list of all pharmacists", notes = "Returns list of all pharmacists")
	public List<Pharmacist> getPharmacists(@ApiParam(value = "Search pharmacist")
										@RequestParam(value = "search", required = false) String search ) {
		return pharmacistService.getPharmacists(search);
	}
	
	@GetMapping(value = {"/pharmacists/{id}", "/admin/pharmacists/{id}"})
	@ApiOperation(value = "Get pharmacist", notes = "Returns pharmacist by id")
	public Pharmacist getPharmacist(@PathVariable String id) {
		return pharmacistService.getPharmacist(id);
	}
	
	@PostMapping(value = "/admin/pharmacists/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create pharmacist", notes = "Creates pharmacist user")
	public void createPharmacist(@RequestBody CreatePharmacistCmd cmd) {
		pharmacistService.createPharmacist(cmd);
	}
	
	@PutMapping(value = "/admin/pharmacists/{id}")
	@ApiOperation(value = "Update pharmacist", notes = "Updates pharmacist user details")
	public void updatePharmacist(@RequestBody CreatePharmacistCmd cmd, @PathVariable String id) {
		pharmacistService.updatePharmacist(cmd, id);
	}
	
	@DeleteMapping(value = "/admin/pharmacists/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete pharmacist", notes = "Deletes pharmacist user")
	public void deletePharmacist(@PathVariable String id) {
		pharmacistService.deletePharmacist(id);
	}

}
