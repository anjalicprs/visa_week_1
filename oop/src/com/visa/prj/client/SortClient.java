package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.ArrayUtil;

public class SortClient {

	public static void main(String[] args) {
		String[] names = {"Bhai", "Ankit", "Anshu"};
		
		ArrayUtil.sort(names);
		for (String string : names) {
			System.out.println(string);
		}
		
		Product[] products = new Product[4]; //Array of 4 pointers
		products[0]= new Tv(133, "Sony", 135000, "LED");
		products[1]= new Mobile(453, "MotoG", 12999, "4G");
		products[2]= new Tv(634, "Onida Thunder", 3500, "CRT");
		products[3]= new Mobile(621, "IPhone XR", 99999, "4G");
		ArrayUtil.sort(products);
		for (Product p : products) {
			System.out.println(p);
		}
	}

}
