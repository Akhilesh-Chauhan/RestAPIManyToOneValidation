package com.akhilesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhilesh.dto.CustomerDto;
import com.akhilesh.entity.Customer;
import com.akhilesh.exception.CidNotFoundException;
import com.akhilesh.repository.CustomerRepository;
@Service
public class CustomerService {
@Autowired
	CustomerRepository crepo;
	public void addData(CustomerDto cdto) {
		// TODO Auto-generated method stub
		Customer cs=new Customer();//transient object
		cs.setCid(cdto.getCid());
		cs.setCnm(cdto.getCnm());
		cs.setDob(cdto.getDob());
		cs.setEmail(cdto.getEmail());
		crepo.save(cs);
	}
	public List<Customer> getData()
	{
		return crepo.findAll();
	}
	public void deleData(Integer cid)
	{
		Customer cs=crepo.findById(cid).orElse(null);
		crepo.delete(cs);
	}
	public void updateData(Integer cid,CustomerDto cdto)
	{
		Customer cs=crepo.findById(cid).orElse(null);
		cs.setCnm(cdto.getCnm());
		cs.setEmail(cdto.getEmail());
		cs.setDob(cdto.getDob());
		crepo.save(cs);
	}
	public CustomerDto findById(Integer cid) throws CidNotFoundException
	{
		Customer cs=crepo.findById(cid).orElse(null);
		if(cs==null)
		{
			throw new CidNotFoundException();
		}
		CustomerDto cdto=new CustomerDto();
		cdto.setCid(cs.getCid());
		cdto.setCnm(cs.getCnm());
		cdto.setDob(cs.getDob());
		cdto.setEmail(cs.getEmail());
		return cdto;
	}
	/*public CustomerDto findById(Integer cid) 
	{
		Customer cs=crepo.findById(cid).orElse(null);
		
		CustomerDto cdto=new CustomerDto();
		cdto.setCid(cs.getCid());
		cdto.setCnm(cs.getCnm());
		cdto.setDob(cs.getDob());
		cdto.setEmail(cs.getEmail());
		return cdto;
	}*/
}

