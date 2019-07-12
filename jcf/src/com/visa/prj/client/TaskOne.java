package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

public class TaskOne {

	public static void main(String[] args) {
		Set<String> uniqueSet = new HashSet<>();
		Set<String> duplicateSet = new HashSet<>();
		String str2 = "we are the world we are the children";
		String[] str = str2.split(" ");
		for(String s:str) {
			if(uniqueSet.contains(s)) {
				duplicateSet.add(s);
			}
			else {
				uniqueSet.add(s);
			}
		}
		uniqueSet.removeAll(duplicateSet);
		for(String s:uniqueSet) {
			System.out.println(s);
		}
		System.out.println("*******");
		for(String s:duplicateSet) {
			System.out.println(s);
		}
	}

}
