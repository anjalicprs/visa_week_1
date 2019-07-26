package com.visa.hotelapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.hotelapp.entity.User;

public interface UserDao extends JpaRepository<User, String> {
	@Query("from User u where u.email = :email and u.password= :pwd")
	List<User> getByEmailAndPassword(@Param("email") String email,@Param("pwd") String pwd);
}
