package com.akhilesh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.akhilesh.dto.LoanDto;
import com.akhilesh.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	@Autowired
	LoanService lservice;
	@Autowired
	Environment enviroment;
	@PostMapping("/loan")
	public ResponseEntity<String> addData(@Valid @RequestBody LoanDto ldto)
	{
		
		lservice.addData(ldto);
		String msg=enviroment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
		
}

