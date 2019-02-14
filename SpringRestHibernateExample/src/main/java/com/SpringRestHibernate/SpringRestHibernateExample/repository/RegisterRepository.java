package com.SpringRestHibernate.SpringRestHibernateExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {

	Register findByuserName(String uname);

}
