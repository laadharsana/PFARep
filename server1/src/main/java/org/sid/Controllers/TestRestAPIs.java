package org.sid.Controllers;

import java.util.List;

import org.sid.Entities.Admin;
import org.sid.repository.AdminRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
  
	private AdminRepository adminrepository;
  @PreAuthorize("hasRole('CADREADMIN') or hasRole('ADMIN')")
@RequestMapping(value="/secured/findAdmin",method=RequestMethod.GET)
		public List<Admin> findAll() {
			return  adminrepository.findAll();  
  }
 
  @GetMapping("/api/test/pm")
  @PreAuthorize("hasRole('ETUDIANT')"/*or hasRole('ADMIN')"*/)
  public String projectManagementAccess() {
    return ">>> Project Management Board";
  }
  
  @GetMapping("/api/test/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return ">>> Admin Contents";
  }
  
  
}