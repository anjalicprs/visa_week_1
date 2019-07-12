package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSecondClient {

	public static void main(String[] args) {
		List<Integer> il = Arrays.asList(1, 23, 45, 67);
		List<String> sl = Arrays.asList("one", "two", "three");
		List<Integer> copyInt = new ArrayList<>();
		List<String> copyStr = new ArrayList<>();
		print(il);
		print(sl);
		copy(copyInt, il);
		copy(copyStr, sl);
		copyOther(copyInt, il);
		copyOther(copyStr, sl);
		print(copyInt);
		print(copyStr);
	}
	private static <T> void copy(List<T> dest, List<T> src) {//Supports when both src and dest are of same type
		for(T o:src) {
			dest.add(o);
		}
	}
	//PECS Producer extends Consumer Super
	//src can be anything which is a supeType of T
	private static <T> void copyOther(List<? super T> dest, List<? extends T> src) {//Supports when both src and dest are of same type
		for(T o:src) {
			dest.add(o);
		}
	}
	private static void print(List<?> il) {//When we use ? then access is allowed but addition is not allowed
		for (Object object : il) {
			System.out.println(object);
		}
	}

}
