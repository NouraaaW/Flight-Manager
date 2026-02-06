/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightmanager;

/**
 *
 * @author منوري
 */
import java.io.Serializable;
import java.util.Scanner;

public class BusinessClass extends Passenger implements Serializable  {

	private boolean VIPstat;
	private int loungAccessNo;

	public static Scanner input = new Scanner(System.in);

	public BusinessClass(String name, String ID, int age, String gender, double LuggageWeight, boolean VIPstat) {
		super(name, ID, age, gender, LuggageWeight);

		System.out.println("Is the Business Passenger a VIP? (yes/no): ");
		String ans = input.next();

		if (ans.equals("yes"))
			this.VIPstat = true;
		else
			this.VIPstat = false;
		
		loungAccessNo = loungAccessNo();

	}

	public BusinessClass(BusinessClass p) {
		super(p.name, p.ID, p.age, p.gender, p.LuggageWeight);

		this.VIPstat = p.VIPstat;
		this.loungAccessNo = p.loungAccessNo;

	}

	public int loungAccessNo() {

		return this.loungAccessNo = (int) (Math.random() * 900000) + 100000;
	}

	public String loungAccess() {

		if (VIPstat) {
			return "The passenger has been granted lounge access, Here is the permit number: " + this.loungAccessNo;
		}
		return "loung Access: " + " Not allowed!";

	}

	public String toString() {

		String Access = "";

		if (this.VIPstat)
			Access = "" + loungAccessNo;
		else
			Access = "Not allowed!";

		return super.toString() + " loung Access: " + Access;
	}

}
