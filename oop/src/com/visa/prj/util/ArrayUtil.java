package com.visa.prj.util;


import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] data) {
		int sum=0;
		for(int num:data) {
			sum+=num;
		}
		return sum;
	}
	public static void sort(Comparable[] elems) { //Understand -> properly follow ocp
		for (int i = 0; i < elems.length; i++) {
			for (int j = i+1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j] )> 0) {
					Comparable temp = elems[i];
					elems[i]=elems[j];
					elems[j]=temp;
				}
			}
		}
	}
	
	public static void sort2(int[] data) {
		Arrays.sort(data);
	}
	public static int getCount(int[] elems, int no) {
		int count=0;
		for(int num:elems) {
			if(num      == no) {
				count++;
			}
		}
		return count;
	}
	
	public static int[] convert(int[][] data) {
		
		int i=0;
		int[] elems = new int[data.length*data[0].length];
		for(int[] num:data) {
			for(int ele:num) {
				elems[i]=ele;
				i++;
			}
		}
		return elems;
		
	}
}
