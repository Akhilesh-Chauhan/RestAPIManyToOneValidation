package com.akhilesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

