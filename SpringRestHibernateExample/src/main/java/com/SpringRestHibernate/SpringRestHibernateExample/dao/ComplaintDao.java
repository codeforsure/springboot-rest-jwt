package com.SpringRestHibernate.SpringRestHibernateExample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRestHibernate.SpringRestHibernateExample.model.Complaint;
import com.SpringRestHibernate.SpringRestHibernateExample.repository.ComplaintRepository;

@Service
public class ComplaintDao {
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	public Complaint save(Complaint complaint){
		return complaintRepository.save(complaint);
	}
	public List<Complaint> findById(Integer Id){
		return complaintRepository.findAllByregister_registerId(Id);
	}
	public void deleteById(Integer Id) {
		complaintRepository.deleteById(Id);
	}
}
