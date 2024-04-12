package com.smk627751;

import java.util.Scanner;

public abstract class Utility {
	private Scanner sc = new Scanner(System.in);
	
	public Scanner getScanner()
	{
		return sc;
	}
	
	public void print(String s)
	{
		System.out.print(s);
	}
}
