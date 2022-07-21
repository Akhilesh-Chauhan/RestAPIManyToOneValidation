package com.akhilesh.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

public class LoanDto {
	
	private Integer loanId;
	private Double amount;
	@PastOrPresent(message="DATE NOT BE EXCEED TODAY'S DATE")
	private LocalDate issueDate;
	@NotEmpty(message="STATUS CAN'T BE BLANK")
	private String status;
	@Valid
	CustomerDto cdto;
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerDto getCdto() {
		return cdto;
	}
	public void setCdto(CustomerDto cdto) {
		this.cdto = cdto;
	}
	
}

