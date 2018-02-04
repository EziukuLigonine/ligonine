package lt.akademija.Service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lt.akademija.Model.Admin;
import lt.akademija.Model.CreateAdminCmd;
import lt.akademija.Repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public List<Admin> getAdmins(String search){
		return search == null ? adminRepository.findAll() : adminRepository.findByNameOrSurname(search);
	}
	
	@Transactional
	public Admin getAdmin(@PathVariable String id) {
		return adminRepository.getOne(Long.parseLong(id));
	}
	
	@Transactional
	public void createAdmin(@RequestBody CreateAdminCmd cmd) {
		Admin admin = new Admin();
		admin.setName(cmd.getName());
		admin.setSurname(cmd.getSurname());
		admin.setUsername(cmd.getUsername());
		admin.setPassword(cmd.getPassword());
		adminRepository.save(admin);
	}
	
	@Transactional 
	public void updateAdmin(@RequestBody CreateAdminCmd cmd, @PathVariable String id) {
		Admin admin = adminRepository.getOne(Long.parseLong(id));
		if(admin != null) {
			BeanUtils.copyProperties(cmd, admin);
			adminRepository.save(admin);
		}
	}
	
	@Transactional
	public void deleteAdmin(@PathVariable String id) {
		adminRepository.delete(Long.parseLong(id));
	}
	

}
