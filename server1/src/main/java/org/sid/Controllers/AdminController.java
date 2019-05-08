package org.sid.Controllers;

import java.io.Serializable;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sid.Entities.Admin;
import org.sid.Entities.Users;
////import org.sid.entities.Enseignant;
import org.sid.repository.AdminRepository;
import org.sid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AdminController implements Serializable
{
	@Autowired
	private AdminRepository adminrepository;


	@RequestMapping("/login")
    public boolean login(@RequestBody Users user) {
        return
          user.getUserName().equals("admin") && user.getPassword().equals("12345");
    }
     
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
	@GetMapping("user/me")
	public Principal user(Principal principal)
	{
		return principal;
	}
	/*@Secured(value= {"ROLE_ADMIN"})*/
	/*
	@RequestMapping(value="/getLogedUser")
    public Map<String,Object> getLogedUser(HttpServletRequest httpServletRequest)
    {
    	HttpSession httpSession=httpServletRequest.getSession();
		SecurityContext securityContext=
				(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
    	String username=securityContext.getAuthentication().getName();
    	List<String> roles= new ArrayList();
    	for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()) {
    		roles.add(ga.getAuthority());
    		
    	}/*
    	Map<String,Object> params=new HashMap<>();
    	params.put("username", username);
    
    	params.put("roles", roles);
    	
		
		return params;}
		*/
   /* @PreAuthorize("hasAnyRole('ADMIN')")*/

	/*@Secured(value= {"ROLE_ADMIN"})*/
	@GetMapping(value="/api/auth/no/affichertout")/*,method=RequestMethod.GET)*/
	public List<Admin> findAll() {
		return  adminrepository.findAll();   
	}
	@RequestMapping(value="/userbyid/{id}",method=RequestMethod.GET)	
	   public Admin getenseignant(@PathVariable Long id){
		return adminrepository.findById(id).orElse(null);
	}
		
}

/*
	@Autowired
	private BCryptPasswordEncoder encoder;
	/*@PreAuthorize("hasAnyRole('ADMIN')")*/
/*
	@RequestMapping(value="/secured/addAdmin",method=RequestMethod.POST)
	public Admin save(@RequestBody Admin u) {
		 u.setPassword(encoder.encode(u.getPassword()));
		return adminrepository.save(u);
	}
}
*/