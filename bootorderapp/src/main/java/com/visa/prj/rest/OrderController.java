package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("orders")
	public @ResponseBody List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@PostMapping("orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order o){
		orderService.addOrder(o);
		return new ResponseEntity<Order>(o, HttpStatus.CREATED);
	}
}
