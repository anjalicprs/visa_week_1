package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public interface MobileDao { 
	//all methods are public abstract
	void addMobile(Mobile m);
	Mobile getMobile(int id);
}
