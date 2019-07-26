package com.visa.prj;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.dto.RaiseTicketUpdateData;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	TicketDao ticketDao;
	
	@Transactional
	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}
	
	public Ticket getTicketById(int id) {
		return ticketDao.findById(id).get();
	}
	
	public List<Ticket> getResolvedTicketByEmployee(Employee e){
		String email = e.getEmail();
		return ticketDao.getResolvedTicketByEmployee(email);
	}
	
	@Transactional
	public ResponseEntity<String> resolveTicket(RaiseTicketUpdateData r, int id) {
		String email = r.getE().getEmail();
		Employee e = employeeDao.findById(email).get();
		if(!e.getDept().equals("IT")) {
			return new ResponseEntity<String>("Only IT people can resolve ticket", HttpStatus.BAD_REQUEST);
		}
		Calendar calendar = Calendar.getInstance();
		ticketDao.resolveTicket(email,calendar.getTime(), id, r.getResolveInfo());
		return new ResponseEntity<String>("Succesfuly Resolved", HttpStatus.ACCEPTED);
	}
	
	public List<Ticket> getAllTicket(){
		return ticketDao.findAll();
	}
}
