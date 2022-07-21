package com.akhilesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer {
	
	@Id
	private Integer cid;
	@Column(length = 25)
	private String cnm;
	@Column(length = 25)
	private String email;
	private LocalDate dob;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCnm() {
		return cnm;
	}
	public void setCnm(String cnm) {
		this.cnm = cnm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}

