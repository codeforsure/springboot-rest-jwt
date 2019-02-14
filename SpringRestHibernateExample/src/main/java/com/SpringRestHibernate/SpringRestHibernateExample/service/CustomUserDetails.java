package com.SpringRestHibernate.SpringRestHibernateExample.service;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;

public class CustomUserDetails implements UserDetails {
	
	private Register register;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return register.getPass();
	}

	@Override
	public String getUsername() {
		return register.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		//System.out.println("pass:"+register.getPass());
		this.register = register;
	}
	

}
