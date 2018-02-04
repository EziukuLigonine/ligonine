package lt.akademija.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lt.akademija.Model.CreatePharmacistCmd;
import lt.akademija.Model.Pharmacist;
import lt.akademija.Repository.PharmacistRepository;

@Service
public class PharmacistService {

	@Autowired
	private PharmacistRepository pharmacistRepository;

	@Transactional
	public List<Pharmacist> getPharmacists(String search) {
		return search == null ? pharmacistRepository.findAll() : pharmacistRepository.findByNameOrSurname(search);
	}

	@Transactional
	public Pharmacist getPharmacist(@PathVariable String id) {
		return pharmacistRepository.getOne(Long.parseLong(id));
	}

	@Transactional
	public void createPharmacist(@RequestBody CreatePharmacistCmd cmd) {
		Pharmacist pharmacist = new Pharmacist();
		pharmacist.setName(cmd.getName());
		pharmacist.setSurname(cmd.getSurname());
		pharmacist.setCompanyType(cmd.getCompanyType());
		pharmacist.setCompanyName(cmd.getCompanyName());
		pharmacist.setUsername(cmd.getUsername());
		pharmacist.setPassword(cmd.getPassword());
		pharmacistRepository.save(pharmacist);
	}

	@Transactional
	public void updatePharmacist(@RequestBody CreatePharmacistCmd cmd, @PathVariable String id) {
		Pharmacist pharmacist = pharmacistRepository.getOne(Long.parseLong(id));
		if (pharmacist != null) {
			BeanUtils.copyProperties(cmd, pharmacist);
			pharmacistRepository.save(pharmacist);
		}
	}

	@Transactional
	public void deletePharmacist(@PathVariable String id) {
		pharmacistRepository.delete(Long.parseLong(id));
	}

}
