package com.vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestNgAssertTest extends TestNgBasicConfigAnnotationPracticeTest{
	
	
	@Test
	public void practice1Test() {
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
		
		
	}
	@Test
	public void practice2Test() {
		System.out.println("d");
		System.out.println("e");
		Assert.fail();
		System.out.println("f");
		 
	}
	@Test(dependsOnMethods = "practice2Test")
	public void practice3Test() {
		System.out.println("g");
		System.out.println("h");
		System.out.println("i");
	}
	@Test
	public void practice4Test() {
		System.out.println("j");
		System.out.println("k");
		System.out.println("l");
		
	}
}
