package com.visa.prj.dto;

import com.visa.prj.entity.Employee;

public class RaiseTicketUpdateData {
	private Employee e;
	private String resolveInfo;
	public Employee getE() {
		return e;
	}
	public void setE(Employee e) {
		this.e = e;
	}
	public String getResolveInfo() {
		return resolveInfo;
	}
	public void setResolveInfo(String resolveInfo) {
		this.resolveInfo = resolveInfo;
	}
	public RaiseTicketUpdateData(Employee e, String resolveInfo) {
		super();
		this.e = e;
		this.resolveInfo = resolveInfo;
	}
	public RaiseTicketUpdateData() {
		super();
	}
	
}
