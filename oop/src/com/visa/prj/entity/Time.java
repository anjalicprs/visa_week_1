package com.visa.prj.entity;

public class Time {
	private int hours;
	private int mins;
	public Time(int hours, int mins){
		this.hours = hours;
		this.mins = mins;
	}
	public int getHours() {
		return hours;
	}
	public int getMins() {
		return mins;
	}
	public Time addTim(Time t2) {
		Time t3= new Time(0, 0);
		t3.hours = this.hours+t2.hours;
		t3.mins=this.mins+t2.mins;
		if(t3.mins >= 60) {
			t3.hours = t3.hours+1;
			t3.mins = t3.mins-60;
		}
	    return t3;
	}
	public static Time addTime(Time t1, Time t2) {
		Time t3 = new Time(0, 0);
		t3.hours = t1.hours+t2.hours;
		t3.mins = t1.mins+t2.mins;
		if(t3.mins >= 60) {
			t3.hours = t3.hours+1;
			t3.mins = t3.mins-60;
		}
		return t3;
		
		
	}

}
