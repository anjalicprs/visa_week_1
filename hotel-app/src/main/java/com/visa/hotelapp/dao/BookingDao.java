package com.visa.hotelapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.hotelapp.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	@Query("from Booking b where b.user.email= :email")
	List<Booking> getByUser(@Param("email") String email);
	//Try join
}
