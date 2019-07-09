package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visa.prj.entity.Time;

public class TimeTest {

	@Test
	public void testAddTim() {
		Time t1 = new Time(1, 4);
		Time t2 = new Time(2, 7);
		Time res = t1.addTim(t2);
		assertEquals(3, res.getHours());
		assertEquals(11, res.getMins());
	}

	@Test
	public void testAddTime() {
		Time t1 = new Time(1, 4);
		Time t2 = new Time(2, 7);
		Time res = Time.addTime(t2, t1);
		assertEquals(3, res.getHours());
		assertEquals(11, res.getMins());
	}

}
