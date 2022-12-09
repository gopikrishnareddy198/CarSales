package com.car.controller;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.model.Booking;
import com.car.model.Car;
import com.car.model.Finance;
import com.car.model.Payment;
import com.car.repository.BookingRepository;
import com.car.repository.CarRepository;
import com.car.repository.FinanceRepository;
import com.car.repository.PaymentRepository;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	BookingRepository repo;

	@Autowired
	CarRepository carRepo;

	@Autowired
	PaymentRepository payRepo;

	@Autowired
	FinanceRepository finRepo;

	@RequestMapping("/list")
	public String bookingList(Model model, HttpServletRequest req) {
		String utype = req.getSession().getAttribute("usertype").toString();
		String uid = req.getSession().getAttribute("userid").toString();
		if (utype.equals("buyer"))
			model.addAttribute("datalist", repo.findAllByBuyerIdAndStatusEquals(uid,"Booked").get());
		else if (utype.equals("seller"))
			model.addAttribute("datalist", repo.findAllBySellerIdAndStatusEquals(uid,"Booked").get());
		else
			model.addAttribute("datalist", repo.findAllByStatus("Booked").get());

		return "booking_list";
	}

	@RequestMapping("/create/{id}")
	public String create(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("car", carRepo.findById(id).get());
		return "booking_create";
	}

	@RequestMapping("/save")
	public String saveBooking(@RequestParam String carId, @RequestParam double amount, @RequestParam String payMode,
			HttpServletRequest req) throws IOException {
		Optional<Booking> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if (idobj.isPresent()) {
			int idnum = Integer.parseInt(idobj.get().getCarId().substring(5));
			idnum++;
			id = "BOOK3" + idnum;
		} else {
			id = "BOOK362353";
		}

		Car car = carRepo.findByCarId(carId).get();

		Booking obj = new Booking();
		obj.setBookingId(id);
		obj.setCarId(carId);
		obj.setSellerId(car.getSellerId());
		obj.setBuyerId(req.getSession().getAttribute("userid").toString());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		obj.setBookingDate(LocalDateTime.now().toString());
		obj.setAmount(amount);
		obj.setPaymentMode(payMode);
		obj.setPaymentStatus("Paid");
		obj.setStatus("Booked");
		repo.save(obj);

		car.setStatus("Booked");
		carRepo.save(car);

		if (!payMode.equals("finance")) {
			Payment pmt = new Payment();
			pmt.setBookingId(id);
			pmt.setPaidAmount(amount);
			pmt.setPaymentDate(LocalDateTime.now().toString());
			pmt.setPaymentMode(payMode);
			payRepo.save(pmt);
			return "redirect:/booking/list";
		} else {
			Finance fin = new Finance();
			fin.setBookingId(id);
			fin.setBuyerId(req.getSession().getAttribute("userid").toString());
			fin.setInterestRate(5);
			fin.setLoanAmount(amount + (amount * 0.05));
			finRepo.save(fin);
			return "redirect:/finance/edit/" + fin.getBookingId();

		}
	}


	@RequestMapping("/sold/{carId}")
	public String empUpdate(@PathVariable String carId) {
		Car obj = carRepo.findByCarId(carId).get();
		obj.setStatus("SOLD");
		carRepo.save(obj);
		
		Booking booking = repo.findByCarId(carId).get();
		booking.setStatus("SOLD");
		repo.save(booking);
		return "redirect:/car/detail/"+carId;
	}

	@RequestMapping("/sold")
	public String soldList(Model model, HttpServletRequest req) {
		String utype = req.getSession().getAttribute("usertype").toString();
		String uid = req.getSession().getAttribute("userid").toString();
		
		if (utype.equals("seller"))
			model.addAttribute("datalist", repo.findAllBySellerIdAndStatus(uid,"SOLD").get());
		else
			model.addAttribute("datalist", repo.findAllByStatus("SOLD").get());

		return "sold_list";
	}

	static String ymd_dmy(String date) throws ParseException {
		String arr[] = date.split("-");
		return arr[2] + "-" + arr[1] + "-" + arr[0];
	}
}
