package com.visa.hotelapp.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.hotelapp.entity.Booking;
import com.visa.hotelapp.entity.Hotel;
import com.visa.hotelapp.entity.User;

public class HotelAppConsumer {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		printHotel(template);
		printUser(template);
		postBooking(template);
	}
	
	public static void printHotel(RestTemplate template) {
		String url = "http://localhost:8080/hotels/{id}";
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		Hotel result = template.getForObject(url, Hotel.class, params);
		System.out.println(result);
		
	}
	
	public static void postBooking(RestTemplate template) {
		String url = "http://localhost:8080/bookings";
		HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 User u = new User();
		 u.setEmail("a@visa.com");
		 Hotel h = new Hotel();
		 h.setId((long) 1);
		 Booking b = new Booking(h, u);
		HttpEntity<Booking> requestEntity = new HttpEntity<Booking>(b, headers);
		ResponseEntity<Booking> result = template.postForEntity(url, requestEntity, Booking.class);
		System.out.println(result.getStatusCode()); // 201 as product row was created
		System.out.println(result.getBody().getId());
	}
	
	public static void printUser(RestTemplate template) {
		String url = "http://localhost:8080/users?email={email}&pwd={pass}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", "a@visa.com");
		params.put("pass", "a2a3");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User u = template.getForObject(url, User.class, params);
		System.out.println(u);
	}

}
