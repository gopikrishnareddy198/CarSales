package com.car.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.model.Seller;
import com.car.repository.BookingRepository;
import com.car.repository.CarRepository;
import com.car.repository.SellerRepository;

@RequestMapping("/seller")
@Controller
public class SellerController {

	@Autowired
	SellerRepository repo;

	@Autowired
	CarRepository carRepo;

	@Autowired
	BookingRepository bookRepo;

	@RequestMapping("/home")
	public String home(Model model, HttpServletRequest req) {

		model.addAttribute("datalist", carRepo.findAllBySellerId(req.getSession().getAttribute("userid").toString()).get());
		return "sell_home";
	}

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest req) {

		model.addAttribute("datalist", repo.findAll());
		return "sell";
	}

	@RequestMapping("/create")
	public String create(Model model) {
		return "sell_create";
	}

	@RequestMapping("/save")
	public String save(Seller obj) {
		Optional<Seller> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if (idobj.isPresent()) {
			int idnum = Integer.parseInt(idobj.get().getSellerId().substring(5));
			idnum++;
			id = "SELER" + idnum;
		} else {
			id = "SELER64901";
		}

		obj.setSellerId(id);
		repo.save(obj);
		return "redirect:/account";
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("obj", repo.findById(id).get());
		return "sell_show";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		Optional<Seller> obj = repo.findById(id);
		repo.delete(obj.get());

		return "redirect:/seller/list";
	}

	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest req) {
		model.addAttribute("obj", repo.findBySellerId(req.getSession().getAttribute("userid").toString()).get());
		return "sell_edit";
	}

	@RequestMapping("/edit/{id}")
	public String adminEdit(Model model, @PathVariable String id, HttpServletRequest req) {
		model.addAttribute("obj", repo.findById(id).get());
		return "sell_edit";
	}

	@RequestMapping("/update")
	public String update(Seller obj, HttpServletRequest req) {
		repo.save(obj);
		if (getUType(req).equals("buyer"))
			return "redirect:/seller/home/";
		else
			return "redirect:/account/home/";

	}

	public static String getUId(HttpServletRequest req) {
		return req.getSession().getAttribute("userid").toString();
	}

	public static String getUType(HttpServletRequest req) {
		return req.getSession().getAttribute("usertype").toString();
	}
}
