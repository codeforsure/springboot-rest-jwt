package com.SpringRestHibernate.SpringRestHibernateExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringRestHibernate.SpringRestHibernateExample.dao.RegisterDao;
import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RegisterDao registerDao; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Register register = registerDao.findByUsername(username);
		CustomUserDetails userDetails = null;
		//System.out.println("name"+register.getUserName());
		if(register!=null) {
			userDetails = new CustomUserDetails();
			userDetails.setRegister(register);
			return userDetails;
		}
		throw new UsernameNotFoundException("Username not registered");
	}

}
