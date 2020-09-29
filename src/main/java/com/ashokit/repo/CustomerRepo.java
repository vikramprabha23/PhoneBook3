package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CustomerDtls;

public interface CustomerRepo extends JpaRepository<CustomerDtls, Serializable> {

}
