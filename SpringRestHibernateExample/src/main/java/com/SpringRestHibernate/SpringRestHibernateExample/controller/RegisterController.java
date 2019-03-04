package com.SpringRestHibernate.SpringRestHibernateExample.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SpringRestHibernate.SpringRestHibernateExample.dao.RegisterDao;
import com.SpringRestHibernate.SpringRestHibernateExample.jwt.JwtProvider;
import com.SpringRestHibernate.SpringRestHibernateExample.message.JwtResponse;
import com.SpringRestHibernate.SpringRestHibernateExample.dao.ComplaintDao;
import com.SpringRestHibernate.SpringRestHibernateExample.model.LoginForm;
import com.SpringRestHibernate.SpringRestHibernateExample.model.Complaint;
import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;
import com.SpringRestHibernate.SpringRestHibernateExample.model.username;
import com.SpringRestHibernate.SpringRestHibernateExample.service.CustomUserDetails;
import com.SpringRestHibernate.SpringRestHibernateExample.validator.UserValidator;


@RestController
public class RegisterController {
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
    JwtProvider jwtProvider;
	@Autowired
    AuthenticationManager authenticationManager;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	Register registerg = new Register();
	CustomUserDetails csd = new CustomUserDetails();
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register")
	public String register(@RequestBody Register register) {
		
		String password = register.getPass();
		String encryptPass = passwordEncoder.encode(password);
		register.setPass(encryptPass);
		registerDao.save(register);
		return "Registered";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public <T> ResponseEntity<?> login(@RequestBody LoginForm loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok((T) new JwtResponse(jwt));
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/name")
	public String getUsername(@RequestBody username name){
		String username= name.getUsername();
		System.out.println("user name"+username);
		registerg = registerDao.findByUsername(username);
		return "sucess";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/complaint")
	public String Complaint(@RequestBody Complaint complaint) {
		complaint.setRegister(registerg);
		complaintDao.save(complaint);
		return "sucess";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/complaint/add")
	public List<Complaint> addComplaint(){
		System.out.println("user id"+registerg.getRegister_id());
		return complaintDao.findById(registerg.getRegister_id());
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/complaint/delete")
	public String deleteComplaint(@RequestBody Complaint complaint) {
		complaintDao.deleteById(complaint.getComplaint_id());;
		return "sucess";
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/complaint/update")
	public String updateComplaint(@RequestBody Complaint complaint) {
		Complaint cmp = new Complaint();
		cmp.setComplaint(complaint.getComplaint());
		cmp.setComplaint_id(complaint.getComplaint_id());
		complaintDao.save(cmp);
		return "sucess";
	}
}