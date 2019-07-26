package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
	@Query("from Ticket t where t.resolvedBy.email=:email")
	List<Ticket> getResolvedTicketByEmployee(@Param("email") String email);
	
	@Modifying(clearAutomatically = true)
	@Query("update Ticket t set t.resolvedBy.email=:email, t.isResolved=0, t.releaseDate=:date "
			+ ",t.resolveInfo=:info  where t.id=:id")
	void resolveTicket(@Param("email") String email, @Param("date") Date d, @Param("id") Integer id,@Param("info") String info);
	
}
