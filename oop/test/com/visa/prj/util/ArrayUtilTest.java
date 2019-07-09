package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {2, 4, 5, 6};
		int expected = 17;
		assertEquals(expected, ArrayUtil.getSum(data));
	}

	@Test
	public void testSort() {
		int[] data = {3, 7, 2, 1};
		int[] expected = {1, 2, 3, 7};
		ArrayUtil.sort2(data);
		assertArrayEquals(expected, data);
	}

	@Test
	public void testGetCount() {
		int[] data = {3, 7, 2, 1};
		int expected = 1;
		assertEquals(expected, ArrayUtil.getCount(data, 1));
	}
	
	@Test
	public void testConvert() {
		int[][] data = {{1,2},{1,3}};
		int[] expected = {1, 2, 1, 3};
		assertArrayEquals(expected, ArrayUtil.convert(data));
	}

}