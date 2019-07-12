package com.visa.prj.client;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) {
		Map<String, Double> map = new WeakHashMap<>();
		String s = new String("Java"); // This is okay 
		//But if we give s = "Java" by literals then gc will not collect
		map.put(s, 123.55);
		s = null;
		System.gc();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(map.get("Java"));
	}

}
