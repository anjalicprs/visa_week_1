package com.visa.hotelapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.hotelapp.entity.Booking;
import com.visa.hotelapp.entity.Hotel;
import com.visa.hotelapp.entity.User;
import com.visa.hotelapp.service.BookingService;


@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@GetMapping("hotels/{id}")
	public @ResponseBody Hotel getHotelById(@PathVariable("id") long id) {
		//return orderService.getAllProduct().stream().filter(p->p.getId()==id).findFirst().get();
		return bookingService.getHotelById(id);
	}
	
	@GetMapping("users")
	public @ResponseBody User getUser(@RequestParam(name="email", required=false) String email, @RequestParam(name="pwd", required=false) String pwd){
		return bookingService.getUserByEmailAndPass(email, pwd);
	}
	
	@PostMapping("bookings")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b){
		bookingService.saveBooking(b);
		return new ResponseEntity<Booking>(b, HttpStatus.CREATED);
	}
	
	@GetMapping("hotels")
	public @ResponseBody List<Hotel> getHotelByCriteria(@RequestParam(name="cri", required=true) String crit) {
		return bookingService.findHotels(crit);
	}
	
	@GetMapping("bookings")
	public @ResponseBody List<Booking> getBooking(@RequestParam(name="useremail", required=true) String email){
		return bookingService.getAllBookingByUser(email);
	}
		
}
