package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Transactional
	public void addProduct(Product p) {
		productDao.save(p);
	}
	
	public List<Product> getAllProduct(){
		return productDao.findAll();
	}
	
	public List<Product> getProductByCategory(String category){
		return productDao.findByCategory(category);
	}
	
	public Product getProductById(int id) {
		return productDao.findById(id).get();
	}
	
	@Transactional
	public void addOrder(Order o) {
		orderDao.save(o);
	}
	
	public List<Order> getOrders(){
		return orderDao.findAll();
	}
}
