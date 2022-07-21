package com.akhilesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.entity.Loan;
@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer>{

}

