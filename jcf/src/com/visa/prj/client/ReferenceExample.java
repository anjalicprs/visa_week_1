package com.visa.prj.client;

import java.lang.ref.SoftReference;

public class ReferenceExample {
	public static void main(String[] args) {
//		WeakReference<String> wr = new WeakReference<String>(new String("Hello"));
		//will keep until heap is out of memory.
		//Very good for using cache implementation
		SoftReference<String> wr = new SoftReference<String>(new String("Hello"));
		System.out.println(wr.get());
		//Calling garbage collector gc
		System.gc();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(wr.get());
	}
}
