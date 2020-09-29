package com.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.pojo.CustomerDto;
import com.ashokit.service.CustomerService;

@Controller
public class CustomerViewController {

	@Autowired
	private CustomerService service;
	
	
	@GetMapping("/editContact/{cid}")
	public String editContact(@PathVariable("cid") Integer cid, Model model) {
		CustomerDto dto=service.getOneCustomer(cid);
		System.out.println(dto);
		System.out.println(cid);
		model.addAttribute("contact", dto);
		return "index";
	}
	@GetMapping("/deleteContact/{cid}")
	public String deleteContact(@PathVariable("cid") Integer cid, RedirectAttributes ratt) {
		service.deleteCustomer(cid);
		ratt.addFlashAttribute("msg", "deleted succeefully");
		return "redirect:../showContacts";
	}
}
