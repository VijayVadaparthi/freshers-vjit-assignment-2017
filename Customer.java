package com.rubicon.vjit;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;



public class Customer{
	private String name;
	private int id;
	private long ph;
	public Customer() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		id = rand.nextInt(100);
		System.out.print("\n Enter Customer Name and Phone Number: ");
		name =sc.next();;
		ph=sc.nextLong();
		try {
			File f = new File("CustomerRegister.txt");
			FileWriter fw = new FileWriter(f,true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter pw = new PrintWriter(bw);
		    pw.print(id);pw.print(" "+name);pw.println(" "+ph);
		    pw.close();
		}catch(Exception e) {
			e.printStackTrace();
	  }
	}
	public void requestMenu() {
		System.out.println("\n Customer requests MenuCard");
	}
	public void orderFood() {
		System.out.println("\n Customer orders Food");
	}
	public void eatFood() {
		System.out.println("\n Customer completes eating the Food");
	}
	public void requestBill() {
		System.out.println("\n Customer requests Bill");
	}
	public void payBill(float a) {
		System.out.println("\n Customer pays "+a+" rupees and Exits the Restaurant");
	}
}
