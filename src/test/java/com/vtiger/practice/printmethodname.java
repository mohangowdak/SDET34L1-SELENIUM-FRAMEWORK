package com.vtiger.practice;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class printmethodname {
	@Test
public void main(Method mtd) {
		System.out.println(mtd.getName());
}
}
