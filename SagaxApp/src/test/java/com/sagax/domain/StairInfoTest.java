package com.sagax.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StairInfoTest {
	
	StairInfo testInfo;
	
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Before
	public void before()
	{
		testInfo = new StairInfo(8, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50});
	}
	
	@Test
	public void testStepsInStride()
	{
		assertEquals(8, testInfo.getStepsInStride());
	}
	
	@Test
	public void testStepsPerFlight()
	{
		
		try {
			assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}, testInfo.getStepsPerFlight());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testConstraintsStepsPerFlight()
	{
		
		try {
			testInfo.applyConstraints();
			assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}, testInfo.getStepsPerFlight());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testConstraintsStrideSize()
	{
		
		try {
			testInfo.applyConstraints();
			assertEquals(4, testInfo.getStepsInStride());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testConstrainArraySize()
	{
		
		try {
			testInfo.applyConstraints();
			assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}, testInfo.getStepsPerFlight());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	@After
	public void after()
	{
		
	}
	
	@AfterClass
	public static void afterClass()
	{
		
	}
}