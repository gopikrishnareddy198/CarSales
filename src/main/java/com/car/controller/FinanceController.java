package com.car.controller;

import com.car.model.Finance;
import com.car.repository.FinanceRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/finance")
@Controller
public class FinanceController {

	@Autowired
	FinanceRepository repo;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest req) {
		String utype = req.getSession().getAttribute("usertype").toString();
		String uid = req.getSession().getAttribute("userid").toString();
		if (utype.equals("buyer"))
			model.addAttribute("datalist", repo.findAllByBuyerId(uid).get());
		else
			model.addAttribute("datalist", repo.findAll());

		return "finance";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model, HttpServletRequest req) {
		model.addAttribute("obj", repo.findByBookingId(id).get());
		return "finance_edit";
	}

	@RequestMapping("/update")
	public String update(Finance obj) {
		repo.save(obj);
		return "redirect:/buyer/home/";
	}

}
