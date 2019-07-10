package com.visa.prj.client;

interface Computation {
	int compute(int x, int y);
	/*
	 * Interface having only one method is called functional 
	 * interface.
	 */
}

public class TestAnonymous {

	public static void main(String[] args) {
		Computation c1 = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x*y;
			}
		};
		System.out.println(c1.compute(5, 4));
		/*
		 * Java 8 introduced Lambda expression 
		 * as a shorter form for anonymous class
		 * Limitations is interface only has one function 
		 * in it
		 */
		Computation c2 = (int x, int y)->{
			return x+y;
		};
		
		Computation c3 = (x,y)->x-y;//Type interface
		System.out.println(c2.compute(5, 4));
		System.out.println(c3.compute(5, 4));
	}
	

}
