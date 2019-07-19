package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;
	
	@Transactional
	public long doBooking(Booking b) {
		long id = bookingDao.createBooking(b);
		return id;
	}
	
	public Hotel getHotelById(int id){
		return bookingDao.findHotelById(id);
	}
	
	public User getUserByEmail(String email, String pwd) {
		return bookingDao.getUser(email, pwd);
	}
	public List<Hotel> getHotels(String criteria){
		return bookingDao.findHotels(criteria);
	}
	
	public List<Booking> getBookingOfUser(User u){
		return bookingDao.getAllBookingsOfUser(u);
	}
	
}
