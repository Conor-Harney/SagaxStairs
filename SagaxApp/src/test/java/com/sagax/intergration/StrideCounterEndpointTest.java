package com.sagax.intergration;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.sagax.domain.StairInfo;
import com.sagax.util.JSONUtil;


public class StrideCounterEndpointTest {
	
	StrideCounterEndpoint testClass = new StrideCounterEndpoint();
	JSONUtil util = new JSONUtil();
	StairInfo testStairInfo;
	String testStr;
	
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Before
	public void before()
	{
		testStairInfo = new StairInfo(2, new int[] {2,2,2});
		testStr = util.getJSONForObject(testStairInfo);
	}
	
	@Test
	public void test()
	{	
		System.out.println(testStr);
		try 
		{
			assertEquals("\"7\"", testClass.getStrides(testStr));
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
