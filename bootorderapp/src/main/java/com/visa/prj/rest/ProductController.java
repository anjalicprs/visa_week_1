package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class ProductController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("products")
	public @ResponseBody List<Product> getProducts(@RequestParam(name="category", required=false) String category){
		if(category!=null) {
			return orderService.getProductByCategory(category);
		}else {
			return orderService.getAllProduct();
		}
	}
	
	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		orderService.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	@GetMapping("products/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		//return orderService.getAllProduct().stream().filter(p->p.getId()==id).findFirst().get();
		return orderService.getProductById(id);
	}
	
}
