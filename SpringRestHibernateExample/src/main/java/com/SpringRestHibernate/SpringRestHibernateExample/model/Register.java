package com.SpringRestHibernate.SpringRestHibernateExample.model;

import java.util.List;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="register")
@EntityListeners(AuditingEntityListener.class)
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="register_id")
	private Integer registerId;
	
	@Column(name="Full_name",nullable=false)
	private String fullName;
	
	@Column(name="Email",nullable=false)
	private String email;
	
	@Column(name="user_name",nullable=false)
	private String userName;
	
	@Column(name="Password",nullable=false)
	private String pass;

	public Integer getRegister_id() {
		return registerId;
	}

	public void setRegister_id(Integer register_id) {
		this.registerId = register_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
