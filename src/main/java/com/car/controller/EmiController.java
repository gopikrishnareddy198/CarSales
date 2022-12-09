package com.car.controller;

import com.car.model.Emi;
import com.car.model.Finance;
import com.car.repository.EmiRepository;
import com.car.repository.FinanceRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/emi")
@Controller
public class EmiController {

	
	@Autowired
	EmiRepository repo;	
	
	@Autowired
	FinanceRepository finRepo;

	@RequestMapping("/list/{id}")
	public String home(@PathVariable String id, Model model, HttpServletRequest req) {
		model.addAttribute("datalist", repo.findAllByFinanceId(id).get());
		model.addAttribute("financeId", id);
		return "emi";
	}

	@RequestMapping("/create/{id}")
	public String create(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("financeId", id);
		model.addAttribute("emiAmount", finRepo.findById(id).get().getEmi());
		return "emi_create";
	}

	@RequestMapping("/save")
	public String save(Emi obj) throws IOException{
		repo.save(obj);		
		
		Finance fin = finRepo.findById(obj.getFinanceId()).get();
		fin.setPaidEmis(fin.getPaidEmis()+1);
		finRepo.save(fin);
		
		return "redirect:/emi/list/"+obj.getFinanceId();
	}


}
