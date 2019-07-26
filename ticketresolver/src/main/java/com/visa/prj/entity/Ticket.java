package com.visa.prj.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private String category;
	private Date releaseDate;
	private Date raisedDate;
	private boolean isResolved;
	private String resolveInfo;
	public String getResolveInfo() {
		return resolveInfo;
	}
	public void setResolveInfo(String resolveInfo) {
		this.resolveInfo = resolveInfo;
	}
	public boolean isResolved() {
		return isResolved;
	}
	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}
	public Date getRaisedDate() {
		return raisedDate;
	}
	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}
	@ManyToOne
	@JoinColumn(name="raiser_email")
	private Employee raisedBy;
	
	@ManyToOne
	@JoinColumn(name="resolver_email")
	private Employee resolvedBy;
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public Ticket() {
		super();
	}
	public Ticket(String description, String category, Employee raisedBy) {
		super();
		Calendar calendar = Calendar.getInstance();
		this.description = description;
		this.category = category;
		this.setRaisedDate(calendar.getTime());
		this.setResolved(false);
		this.raisedBy = raisedBy;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Employee getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}
	public Employee getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
}
