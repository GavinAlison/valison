package com.alison.base.stringDemo;

import java.io.Console;
import java.util.Scanner;

import org.junit.Test;


public class SystemDemo {
	
	
	
	//new Scanner(InputStream in)
	@Test
	public void test() {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.next();
		scan.nextInt();
		scan.nextFloat();
		scan.nextDouble();
		scan.hasNext();
		scan.hasNextInt();
		
		
		Console cons = System.console();
		cons.readLine();
		cons.readPassword();
		
	}
	@Test
	public void test01(){
		System.out.printf("%8.2f", 123f);
	}
	
	
	
	
	
	
	
}
