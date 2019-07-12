package com.visa.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<>();
		map.put("Java", 2000.00);
		map.put("Oracle", 2500.00);
		map.put("Java", 5000.00);
		//System.out.println(map.get("Java"));
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(map.get(key));
		}
		System.out.println("**************************");
		
		keys.forEach(System.out::println); //uses consumer as arguments
		map.forEach((k, v)->System.out.println(k+" : "+v)); //Takes a biConsumer as arguments
	}

}
