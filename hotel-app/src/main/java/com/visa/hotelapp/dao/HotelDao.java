package com.visa.hotelapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.hotelapp.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {
	@Query("from Hotel where country like :s")
	List<Hotel> getByCriteria(@Param("s") String criteria);
}
