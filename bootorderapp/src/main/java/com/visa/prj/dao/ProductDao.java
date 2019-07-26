package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String category);
	
//	@Query("from products p where p.price between :low and :high")
//	List<Product> getByPriceRange(@Param("low") double lower,@Param("high") double higher);
}
