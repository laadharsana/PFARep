package org.sid.Controllers;

import java.util.List;

import org.sid.Entities.Admin;
import org.sid.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class NewC {
	@Autowired
	private AdminRepository adminrepository;
	@RequestMapping(value="/secured/affichet",method=RequestMethod.GET)
	public List<Admin> findAll() {
		return  adminrepository.findAll();   
	}

}
