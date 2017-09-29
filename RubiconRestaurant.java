package com.rubicon.vjit;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RubiconRestaurant {
	public static void main(String []args) throws FileNotFoundException, IOException {
		float bill;
	DoorBoy db = new DoorBoy();  //DoorBoy who invites at the Entry of the Restaurant
	db.greeting1();
	Customer c = new Customer();  //Customer who visits the Restaurant
	Host h = new Host();  //Host(s) who allots tables & chairs for the customers
	h.setTable();
	BusBoy bb = new BusBoy();  //BusBoy(s) who supply water, clean table etc.,
	bb.serveWater();
	c.requestMenu();
	Manager mg = new Manager();  //Manager who maintains the activites of the Restaurant
	mg.showMenu();
	c.orderFood();
	mg.takeOrder();
	Exec_Chef ec = new Exec_Chef();  //Executive Chef who guides and expedites in-time preparation & delivery from Cooking end
	ec.receiveOrder();
	LineCook lc = new LineCook();  //LineCook(s) who prepares the food
	lc.prepareFood();
	Server s = new Server();  //Server(s) who serves food
	s.serve();
	c.eatFood();
	c.requestBill();
	bill = mg.prepareBill();  //This is Bill section
	c.payBill(bill);
	mg.feedback();  //This is the Feedback section
	c.exit();
	bb.cleanTable();
	bb.layoutCloth();
	db.greeting2();
	}
}
