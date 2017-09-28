package com.rubicon.vjit;

import java.util.Scanner;

public class Host {
	public void setTable() {
		int n;
		Scanner sc =new Scanner(System.in);
		System.out.print("\n Enter No. of People to dine : ");
		n = sc.nextInt();
		System.out.println("\n Host allots Table with "+n+" chairs to the Customer");
	}

}
