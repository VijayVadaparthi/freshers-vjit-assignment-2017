package com.rubicon.vjit;

import java.util.Scanner;

public class Host {
	public void setTable() throws InterruptedException {
		int n;
		Scanner sc =new Scanner(System.in);
		System.out.print("\n Enter No. of People to dine : ");
		n = sc.nextInt();
		Thread.sleep(1500);
		System.out.println("\n Host allots Table with "+n+" chairs to the Customer");
	}

}
