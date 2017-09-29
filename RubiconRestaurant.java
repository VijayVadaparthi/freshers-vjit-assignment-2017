package com.rubicon.vjit;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RubiconRestaurant {
	public static void main(String []args) throws FileNotFoundException, IOException, InterruptedException {
		float bill;
	DoorBoy db = new DoorBoy();  //DoorBoy who invites at the Entry of the Restaurant
	db.greeting1();
	Customer c = new Customer();  //Customer who visits the Restaurant
	Host h = new Host();  //Host(s) who allots tables & chairs for the customers
	Thread.sleep(1500);
	h.setTable();
	BusBoy bb = new BusBoy();  //BusBoy(s) who supply water, clean table etc.,  
	Thread.sleep(1500);
	bb.serveWater();
	Thread.sleep(1500);
	c.requestMenu();
	Manager mg = new Manager();  //Manager who maintains the activites of the Restaurant
	Thread.sleep(1500);
	mg.showMenu();
	Thread.sleep(1500);
	c.orderFood();
	Thread.sleep(1500);
	mg.takeOrder();
	Exec_Chef ec = new Exec_Chef();  //Executive Chef who guides and expedites in-time preparation & delivery from Cooking end
	Thread.sleep(1500);
	ec.receiveOrder();
	LineCook lc = new LineCook();  //LineCook(s) who prepares the food
	Thread.sleep(1500);  
	lc.prepareFood();
	Server s = new Server();  //Server(s) who serves food
	Thread.sleep(1500);
	s.serve();
	Thread.sleep(1500);
	c.eatFood();
	Thread.sleep(1500);
	c.requestBill();
	Thread.sleep(1500);
	bill = mg.prepareBill();  //This is Bill section
	Thread.sleep(1500);
	c.payBill(bill);
	Thread.sleep(1500);
	mg.feedback();  //This is the Feedback section
	Thread.sleep(1500);
	c.exit();
	Thread.sleep(1500);
	bb.cleanTable();
	Thread.sleep(1500);
	bb.layoutCloth();
	Thread.sleep(1500);
	db.greeting2();
	}
}

