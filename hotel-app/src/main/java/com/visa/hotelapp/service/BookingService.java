package com.visa.hotelapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.hotelapp.dao.BookingDao;
import com.visa.hotelapp.dao.HotelDao;
import com.visa.hotelapp.dao.UserDao;
import com.visa.hotelapp.entity.Booking;
import com.visa.hotelapp.entity.Hotel;
import com.visa.hotelapp.entity.User;

@Service
public class BookingService {
	@Autowired
	BookingDao bookingDao;
	@Autowired
	UserDao userDao;
	@Autowired
	HotelDao hotelDao;
	
	public Hotel getHotelById(long id) {
		return hotelDao.findById(id).get();
	}
	
	@Transactional
	public void saveBooking(Booking b) {
		bookingDao.save(b);
	}
	
	public User getUserByEmailAndPass(String email, String pwd) {
		return userDao.getByEmailAndPassword(email, pwd).get(0);
	}
	
	public List<Booking> getAllBookingByUser(String email){
		return bookingDao.getByUser(email);
	}
	
	public List<Hotel> findHotels(String criteria) {
		return hotelDao.getByCriteria(criteria);
	}
	
}
