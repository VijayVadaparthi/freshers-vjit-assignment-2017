package com.rubicon.vjit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Manager {
	static Hashtable<Integer,Float> table = new Hashtable<Integer,Float>();
	static Hashtable<Integer,String> item = new Hashtable<Integer,String>();
	ArrayList<Integer> orders = new ArrayList<Integer>();
	ArrayList<Integer> quantity = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);
	String line,token1 = null,token2,token3 = null;
	StringTokenizer token;
	int ch,i,q;
	
	public void showMenu() throws IOException,FileNotFoundException, InterruptedException {
		System.out.println("\n Manager shows Menu Card ");
		Thread.sleep(1500);
		System.out.print("\nStarter's Menu: \n\n No. Dish Name  Price \n-------------------------\n");
		BufferedReader b1 = new BufferedReader(new FileReader("Starters.txt"));
		while((line=b1.readLine())!=null) {
			System.out.println(line);
			token = new StringTokenizer(line," ");
			while(token.hasMoreTokens()) {
				token1=token.nextToken();
				token2=token.nextToken();
				token3=token.nextToken();
			}
			item.put(Integer.parseInt(token1), token2);
			table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b1.close();
		Thread.sleep(1500);
		System.out.println("\nMainCourse Menu: \n\n No. Dish Name  Price \n-------------------------\n");
		BufferedReader b2 = new BufferedReader(new FileReader("MainCourse.txt"));
		while((line=b2.readLine())!=null) {
		        System.out.println(line);
		        token = new StringTokenizer(line," ");
				while(token.hasMoreTokens()) {
					token1=token.nextToken();
					token2=token.nextToken();
					token3=token.nextToken();
				}
				item.put(Integer.parseInt(token1), token2);
				table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b2.close();
		Thread.sleep(1500);
		System.out.println("\nDessert's Menu: \n\n No. Dish Name  Price \n-------------------------\n");
		BufferedReader b3 = new BufferedReader(new FileReader("Desserts.txt"));
		while((line=b3.readLine())!=null) {
		        System.out.println(line);
		        token = new StringTokenizer(line," ");
				while(token.hasMoreTokens()) {
					token1=token.nextToken();
					token2=token.nextToken();
					token3=token.nextToken();
				}
				item.put(Integer.parseInt(token1), token2);
				table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b3.close();
		
    }
	
	public void takeOrder() throws InterruptedException {
	    ch=1;
		System.out.println("\n Manager takes Order: \n Enter the Dish Item No. with Quantity for ordering and 0 for confirm:\n");
		while(ch>0) {
			i=sc.nextInt();
			if(i>0) {
				orders.add(i);
				q=sc.nextInt();
				quantity.add(q);
			}
			ch=i;
	    }
		Thread.sleep(1500);
		System.out.println("\nOrdered Items with quantities: "+orders+" "+quantity);
		Thread.sleep(1500);
		System.out.println("\n Manager confirms Order and alerts Executive chef");
		
	}
	
	public float prepareBill() throws InterruptedException{
		int size,o,q,p,l,j;
		Float sum=0f;
		size = orders.size();
		System.out.println("\n Manager handovers the Bill to the Customer");
		Thread.sleep(1500);
		System.out.println("-----------------------------------------------------------------\n Item			Quantity	Price\n-----------------------------------------------------------------");
		for(i=0;i<size;i++) {
			o = orders.get(i);
			System.out.print(item.get(o));
			l=(item.get(o)).length();
			for(j=l;j<26;j++) {
				System.out.print(" ");
			}
			q = quantity.get(i);
			System.out.print(q+"		");
			System.out.println((table.get(o))*q);
			sum = sum + ((table.get(o))*q);
		}
		System.out.println("\n----------------------------\n Total Bill : "+sum+" rupees\n----------------------------");
		return sum;
	}
    
	public void feedback() {
		System.out.println("\n Manager asks for Feedback");
		try {
			File f = new File("Feedback.txt");
			FileWriter fw = new FileWriter(f,true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter pw = new PrintWriter(bw);
		    Thread.sleep(1500);
		    System.out.println("\n Customer Feedback: \n-------------------\n");
		    line = sc.next();
		    line+=sc.nextLine();
		    pw.println(line);
		    pw.close();
		
		}catch(Exception e) {
			e.printStackTrace();
	  }
		
	}
	
	
}
