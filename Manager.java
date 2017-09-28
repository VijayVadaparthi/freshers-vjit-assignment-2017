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
	ArrayList<Integer> orders = new ArrayList<Integer>();
	ArrayList<Integer> quantity = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);
	String line,token1 = null,token2,token3 = null;
	StringTokenizer token;
	int ch,i,q;
	
	public void showMenu() throws IOException,FileNotFoundException {
		System.out.println("\n Manager shows Menu Card ");
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
			table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b1.close();
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
				table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b2.close();
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
				table.put(Integer.parseInt(token1), Float.parseFloat(token3));
		}
		b3.close();
		
    }
	
	public void takeOrder() {
	    ch=1;
		System.out.println("\n Enter the Dish Item No. with Quantity for ordering and 0 for exit:\n");
		while(ch>0) {
			i=sc.nextInt();
			if(i>0) {
				orders.add(i);
				q=sc.nextInt();
				quantity.add(q);
			}
			ch=i;
	    }
		System.out.println("\nOrdered Items with quantities: "+orders+" "+quantity);
		System.out.println("\n Manager takes Order and alerts Executive chef");
		
	}
	
	public float prepareBill(){
		int size,o,q,p;
		Float sum=0f,v=0f;
		size = orders.size();
		for(i=0;i<size;i++) {
			o = orders.get(i);
			q = quantity.get(i);
			sum = sum + ((table.get(o))*q);
		}
		System.out.println("\n Manager handovers the Bill to the Customer.\n----------------------\n Bill : "+sum+" rupees\n----------------------");
		return sum;
	}
    
	public void feedback() {
		System.out.println("\n Manager asks for Feedback");
		try {
			File f = new File("Feedback.txt");
			FileWriter fw = new FileWriter(f,true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter pw = new PrintWriter(bw);
		    if(f.exists()==false) {
		    	f.createNewFile();
		    }
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
