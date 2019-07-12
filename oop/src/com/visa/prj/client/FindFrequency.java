package com.visa.prj.client;

import java.util.Map;
import java.util.TreeMap;

public class FindFrequency {

	public static void main(String[] args) {
		String str = "java is oop and java is distributed and java is simple";
		String[] str2 = str.split(" ");
		Map<String, Integer> map = new TreeMap<>();
		for (String string : str2) {
			if(map.get(string)==null) {
				map.put(string, 1);
			}
			else {
				Integer i = map.get(string);
				i = i+1;
				map.put(string, i);
			}
		}
		
		System.out.println(map);
		map.forEach((k, v)->{
			System.out.println(k+" : "+v);
		});
	}

}
