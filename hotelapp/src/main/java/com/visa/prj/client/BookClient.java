package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;


public class BookClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ApplicationContext ctx = new ClassPathXmlBeanApplicationContext("beans.xml");
		ctx.scan("com.visa");
		ctx.refresh();
		
		BookingService bookingService = ctx.getBean("bookingService", BookingService.class);
		User u = bookingService.getUserByEmail("a@visa.com", "a2a3a1a2");
		System.out.println(u);
		Hotel h = bookingService.getHotelById(4);
		System.out.println(h + " hey");
		Booking b = new Booking(h, u);
		Long id = bookingService.doBooking(b);
		List<Booking> bookings = bookingService.getBookingOfUser(u);
		//List<Hotel> hotels = bookingService.getHotels("Aust");
//		System.out.println(hotels);
		System.out.println(bookings);
		System.out.println("Booking created with id "+id);
		
	}
}
