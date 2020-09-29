package com.ashokit.service;

import java.util.List;

import com.ashokit.pojo.CustomerDto;

public interface CustomerService {

	public boolean saveCustomer(CustomerDto dto);
	
	public List<CustomerDto> getAllCustomers();
	
	public CustomerDto getOneCustomer(Integer id);
	
	public boolean deleteCustomer(Integer id);
	
	
	
}
