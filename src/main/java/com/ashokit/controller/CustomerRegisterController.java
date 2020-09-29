package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.pojo.CustomerDto;
import com.ashokit.service.CustomerService;

@Controller
public class CustomerRegisterController {

	@Autowired
	private CustomerService service;
	
	@GetMapping(value= {"/","loadForm"})
	public String index(Model model) {
		CustomerDto dto= new CustomerDto();
		model.addAttribute("contact", dto);
		return "index";
	}
	
	@PostMapping("/submit")
	public String saveCustoer(@ModelAttribute("contact")CustomerDto dto, RedirectAttributes ratt) {
		
		boolean isSaved=service.saveCustomer(dto);
		if(isSaved)
		{
			if(dto.getCid()!=null)
				ratt.addFlashAttribute("succMsg", "contact updated");
			else
			ratt.addFlashAttribute("succMsg", "contact saved");
		}
		else 
			ratt.addFlashAttribute("erroMsg", "contact not saved");
		
		return "redirect:loadForm";
	}
	
	@GetMapping("/showContacts")
	public String showContacts(Model model) {
		List<CustomerDto> listDto=service.getAllCustomers();
		model.addAttribute("list", listDto);
		return "listContacts";
	}
}
