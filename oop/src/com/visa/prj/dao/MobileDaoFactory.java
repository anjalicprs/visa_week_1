package com.visa.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	private static String NAME="";
	static {
		ResourceBundle res = ResourceBundle.getBundle("config");//read properties file
		NAME = res.getString("MOBILE_DAO").trim(); //get className in string form
	}
	public static MobileDao getMobileDao() {
		try {
			return (MobileDao)Class.forName(NAME).newInstance(); //create new inst of loaded class
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
