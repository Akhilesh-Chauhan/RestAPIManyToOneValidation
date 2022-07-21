package com.akhilesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhilesh.dto.LoanDto;
import com.akhilesh.entity.Customer;
import com.akhilesh.entity.Loan;
import com.akhilesh.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository lrepo;
	
	public void addData(LoanDto ldto)
	{
		Loan ln=new Loan();
		ln.setAmount(ldto.getAmount());
		ln.setIssueDate(ldto.getIssueDate());
		ln.setStatus(ldto.getStatus());
		Customer cs=new Customer();
		cs.setCnm(ldto.getCdto().getCnm());
		cs.setCid(ldto.getCdto().getCid());
		cs.setEmail(ldto.getCdto().getEmail());
		cs.setDob(ldto.getCdto().getDob());
		ln.setCustomer(cs);
		lrepo.save(ln);
		
	}
}
