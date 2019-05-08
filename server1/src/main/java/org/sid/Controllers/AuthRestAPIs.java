package org.sid.Controllers;


import java.util.Date;

import java.util.HashSet;


import java.util.Set;
 
import javax.validation.Valid;

import org.sid.Entities.Admin;
import org.sid.Entities.Cadre_Administratif;
import org.sid.Entities.Enseignant;
import org.sid.Entities.Etudiant;
import org.sid.Entities.Role;
////import org.sid.Entities.RoleName;
import org.sid.Entities.Users;
import org.sid.message.request.LoginForm;
import org.sid.message.request.SignUp;

import org.sid.message.response.JwtResponse;
import org.sid.message.response.ResponseMessage;
import org.sid.repository.AdminRepository;
import org.sid.repository.CadreRepository;
import org.sid.repository.EnseignantRepository;
import org.sid.repository.EtudiantRepository;
import org.sid.repository.RoleRepository;

import org.sid.repository.UsersRepository;
import org.sid.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

 @Autowired
 AuthenticationManager authenticationManager;

 @Autowired
 UsersRepository userRepository;

 @Autowired
 AdminRepository adminRepository;

 @Autowired
 EnseignantRepository enseignantRepository;

 @Autowired
CadreRepository cadreRepository;
 
 @Autowired
EtudiantRepository etudiantRepository;
 @Autowired
 RoleRepository roleRepository;

 @Autowired
 PasswordEncoder encoder;

 @Autowired
 JwtProvider jwtProvider;

 @PostMapping("/signin")
 public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

   Authentication authentication = authenticationManager.authenticate(
       new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

   SecurityContextHolder.getContext().setAuthentication(authentication);

   String jwt = jwtProvider.generateJwtToken(authentication);
   UserDetails userDetails = (UserDetails) authentication.getPrincipal();

   return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
 }/*
		public Users(String email, String password, String name, String lastName, Date birthday, int status,
			Set<Role> roles) (String email, String password, String name, String lastName, Date birthday, int status,
		 String username) {
*/
 @PostMapping("/signup")
 public ResponseEntity<?> registerUser(@Valid @RequestBody SignUp signUpRequest) {
   if (userRepository.existsByUsername(signUpRequest.getUsername())) {
     return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
         HttpStatus.BAD_REQUEST);
   }

   if (userRepository.existsByEmail(signUpRequest.getEmail())) {
     return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
         HttpStatus.BAD_REQUEST);
   }
   
 

   // Creating user's account
   /*
   Users user = new Users(signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),
		   signUpRequest.getName(),signUpRequest.getLastName(),
		   signUpRequest.getBirthday(),signUpRequest.getStatus(),signUpRequest.getUsername());
     */

   Set<String> strRoles = signUpRequest.getRole();
   Set<Role> roles = new HashSet<>();
   strRoles.forEach(role -> {
     switch (role) {
     case "admin":
       Role adminRole = roleRepository.findByName("admin")
           .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
     roles.add(adminRole);
      Admin admin = new Admin(signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),
    		   signUpRequest.getName(),signUpRequest.getLastName(),
    		   signUpRequest.getBirthday(),signUpRequest.getStatus(),signUpRequest.getUsername());
	   admin.setRoles(roles);
	  adminRepository.save(admin);
	    break;
   
     case "enseignant":
    	 Role enseignantRole = roleRepository.findByName("enseignant")
         .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
   roles.add(enseignantRole);
    Enseignant enseignant = new Enseignant(signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),
  		   signUpRequest.getName(),signUpRequest.getLastName(),
  		   signUpRequest.getBirthday(),signUpRequest.getStatus(),signUpRequest.getUsername());
    
    enseignant.setRoles(roles);
    enseignantRepository.save(enseignant);
    break;
     case "etudiant":
    	 Role etudiantRole = roleRepository.findByName("etudiant")
         .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
   roles.add(etudiantRole);
    Etudiant etudiant = new Etudiant(signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),
  		   signUpRequest.getName(),signUpRequest.getLastName(),
  		   signUpRequest.getBirthday(),signUpRequest.getStatus(),signUpRequest.getUsername());
    
    etudiant.setRoles(roles);
    etudiantRepository.save(etudiant);
    break;
     case "cadreadmin":
    	 Role CARole = roleRepository.findByName("cadreadmin")
         .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
   roles.add(CARole);
   Cadre_Administratif ca = new Cadre_Administratif(signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),
  		   signUpRequest.getName(),signUpRequest.getLastName(),
  		   signUpRequest.getBirthday(),signUpRequest.getStatus(),signUpRequest.getUsername());
    
    ca.setRoles(roles);
    cadreRepository.save(ca);
    break;
    	 }});
  
   
/*
   user.setRoles(roles);
   userRepository.save(user);
*/
   return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

 }
}