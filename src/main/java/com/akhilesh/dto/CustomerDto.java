package com.akhilesh.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.PastOrPresent;


public class CustomerDto {
	
	private Integer cid;
	@NotEmpty(message="NAME MUST BE GIVEN")
	private String cnm;
	@Email(message="PROVIDE CORRECT MAIL ID")
	private String email;
	@PastOrPresent(message="Date of birth should be past or present date")
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

