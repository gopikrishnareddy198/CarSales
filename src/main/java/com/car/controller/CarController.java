package com.car.controller;

import com.car.model.Car;
import com.car.repository.CarRepository;
import com.car.service.FileUploadUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RequestMapping("/car")
@Controller
public class CarController {

	@Autowired
	CarRepository repo;

	@RequestMapping("/list")
	public String home(Model model, HttpServletRequest req) {
		if (req.getSession().getAttribute("usertype").equals("admin"))
			model.addAttribute("datalist", repo.findAll());
		else
			model.addAttribute("datalist", repo.findBySellerId(req.getSession().getAttribute("userid").toString()).get());
		return "car";
	}

	@RequestMapping("/create")
	public String create(Model model, HttpServletRequest request) {
		return "car_create";
	}

	@RequestMapping("/save")
	public String save(Car obj, @RequestParam("image") MultipartFile multipartFile, HttpServletRequest req) throws IOException{
		Optional<Car> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if(idobj.isPresent())
		{
			int idnum = Integer.parseInt(idobj.get().getCarId().substring(5));
			idnum++;
			id = "CAR03"+idnum;
		}
		else
		{
			id = "CAR0362353";
		}
		
		String imgUrl = id+multipartFile.getOriginalFilename();
		obj.setCarId(id);
		obj.setSellerId(req.getSession().getAttribute("userid").toString());
		obj.setStatus("Available");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		obj.setPostedDate(LocalDateTime.now().toString());
		obj.setImgUrl(imgUrl);
		
		repo.save(obj);		
		
		String uploadDir = "uploads";
        
        FileUploadUtil.saveFile(uploadDir, imgUrl, multipartFile);
		return "redirect:/car/list";
	}

	@RequestMapping("/details/{id}")
	public String Details(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("obj", repo.findById(id).get());
		return "car_details";
	}

	@RequestMapping("/detail/{id}")
	public String Detail(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("obj", repo.findByCarId(id).get());
		return "car_details";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("obj", repo.findById(id).get());
		return "car_show";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		Optional<Car> obj = repo.findById(id);
		repo.delete(obj.get());

		return "redirect:/car/list";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("obj", repo.findById(id).get());
		return "car_edit";
	}

	@RequestMapping("/update")
	public String update(Car obj) {
		repo.save(obj);
		return "redirect:/car/show/" + obj.getId();
	}
}
