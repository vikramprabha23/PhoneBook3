package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CustomerDtls;
import com.ashokit.pojo.CustomerDto;
import com.ashokit.repo.CustomerRepo;

@Service
public class CustomerServieImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public boolean saveCustomer(CustomerDto dto) {
		CustomerDtls entity=new CustomerDtls();
		BeanUtils.copyProperties(dto, entity);
		CustomerDtls savedEntity=repo.save(entity);
		return savedEntity.getCid()!=null;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> listDto=new ArrayList<>();
		List<CustomerDtls> list=repo.findAll();
		list.forEach(entity->{
			CustomerDto dto=new CustomerDto();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		return listDto;
	}

	@Override
	public CustomerDto getOneCustomer(Integer id) {
		Optional<CustomerDtls> opt=repo.findById(id);
		if(opt.isPresent()) {
			CustomerDto dto=new CustomerDto();
			BeanUtils.copyProperties(opt.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
