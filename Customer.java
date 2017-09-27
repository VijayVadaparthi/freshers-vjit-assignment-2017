package com.rubicon.vjit;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Random;



public class Customer{
	private String name;
	private int id;
	private long ph;
	public Customer(String n,long l) {
		Random rand = new Random();
		id = rand.nextInt(100);
		name =n;
		ph=l;
		try {
			File f = new File("F:\\WT\\Java\\GitHub\\RubiconRestaurant\\CustomerRegister.txt");
			FileWriter fw = new FileWriter(f,true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter pw = new PrintWriter(bw);
		    if(f.exists()==true) {
		    	System.out.println("Customer Register file already exists!");
		    }else {
		    	f.createNewFile();
		    	System.out.println("Customer Register file is created");
		    }
		    pw.print(id);pw.print(" "+name);pw.println(" "+l);
		    pw.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void orderFood() {
		System.out.println("Customer orders Food");
	}
	public void eatFood() {
		System.out.println("Customer completes eating the Food");
	}
	public void payBill(double a) {
		System.out.println("Customer pays "+a+" rupees");
	}
}