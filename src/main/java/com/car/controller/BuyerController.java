package com.car.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.model.Buyer;
import com.car.repository.BookingRepository;
import com.car.repository.BuyerRepository;
import com.car.repository.CarRepository;

@RequestMapping("/buyer")
@Controller
public class BuyerController {

	@Autowired
	BuyerRepository repo;
	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	BookingRepository bookRepo;

	
	@RequestMapping("index")
    public String index(Model model) {
        return "index";
    }	
	
	@RequestMapping("/home")
    public String home(Model model, HttpServletRequest req) {
		model.addAttribute("datalist", carRepo.findAllByStatus("Available").get());
		return "buy_home";
    }
	
	
	@RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datalist", repo.findAll());
        return "buy";
    }
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "buy_create";
	}
	
	@RequestMapping("/save")
	public String save( Buyer obj){
		Optional<Buyer> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if(idobj.isPresent())
		{
			int idnum = Integer.parseInt(idobj.get().getBuyerId().substring(5));
			idnum++;
			id = "BUYER"+idnum;
		}
		else
		{
			id = "BUYER64901";
		}
		
		obj.setBuyerId(id);
		repo.save(obj);		
		return "redirect:/account";
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("obj",repo.findById(id).get());
		return "buy_show";
	}
	
	 @RequestMapping("/delete")
	    public String delete(@RequestParam String id) {
	        Optional<Buyer> obj = repo.findById(id);
	        repo.delete(obj.get());

	        return "redirect:/buyer/list";
	    }
	    
	    @RequestMapping("/edit")
	    public String edit( Model model, HttpServletRequest req) {
	        model.addAttribute("obj", repo.findByBuyerId(req.getSession().getAttribute("userid").toString()).get());
	        return "buy_edit";
	    }	    
	    @RequestMapping("/edit/{id}")
	    public String adminEdit( Model model, @PathVariable String id, HttpServletRequest req) {
	        model.addAttribute("obj", repo.findById(id).get());
	        return "buy_edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(Buyer obj, HttpServletRequest req) {
	        repo.save(obj);
	        if(getUType(req).equals("buyer"))
	        return "redirect:/buyer/home/";
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
