package com.SpringRestHibernate.SpringRestHibernateExample.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="complaint")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="complaint_id")
	private Integer complaint_id;
	@Column(name="complaint")
	private String complaint;
	@Column(name="summary")
	private String summary;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="register_id",referencedColumnName = "register_id")
	private Register register;
	
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public Integer getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(Integer complaint_id) {
		this.complaint_id = complaint_id;
	}
	
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	
}
