package com.SpringRestHibernate.SpringRestHibernateExample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringRestHibernate.SpringRestHibernateExample.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer>{
	
	List<Complaint> findAllByregister_registerId(Integer Id);

}
