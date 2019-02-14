package com.SpringRestHibernate.SpringRestHibernateExample.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;
import com.SpringRestHibernate.SpringRestHibernateExample.repository.RegisterRepository;

@Service
public class RegisterDao {
	@Autowired
	RegisterRepository registerRepository ;
	
	//Register user
	public Register save(Register register){
		return registerRepository.save(register);
	}
	public Register findByUsername(String uname) {
		return registerRepository.findByuserName(uname);
	}
	//All Registered Users
	public List<Register> findAll(){ 
		return registerRepository.findAll();
	}
//	//get user with username
//	public Optional<Register> findUser(String uname){
//		return registerRepository.findByfirstName(uname);
//	}
	//Get UserById
	public Optional<Register> findOne(Integer register_id){
		return registerRepository.findById(register_id);
	}
	
	//Delete user
	public void delete(Register register) {
		registerRepository.delete(register);
	}
}
