package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.TicketService;
import com.visa.prj.dto.RaiseTicketUpdateData;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@GetMapping("tickets")
	public @ResponseBody List<Ticket> getEmploeeById() {
		return ticketService.getAllTicket();
	}
	
	@PostMapping("employees")
	public ResponseEntity<Employee> addBooking(@RequestBody Employee e){
		ticketService.addEmployee(e);
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
	}
	
	@PutMapping("tickets/{ticketId}")
	public ResponseEntity<String> resolveTicket(@PathVariable("ticketId") int id,
			@RequestBody RaiseTicketUpdateData r){
		return ticketService.resolveTicket(r, id);
	}
}
