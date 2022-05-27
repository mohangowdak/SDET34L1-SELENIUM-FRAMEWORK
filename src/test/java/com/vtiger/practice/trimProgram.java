package com.vtiger.practice;

public class trimProgram {
public static void main(String[] args) {
	String s1="Mohan";
	String s2=" mohan ";
	
	if(s1.equals(s2.trim())) {
		System.out.println("both strings are same");
	}
	else {
		System.out.println("both strings are not same");
	}
}
}
