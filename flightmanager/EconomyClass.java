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

public class EconomyClass extends Passenger implements Serializable {

	private double LuggageWeightLimit;

	public EconomyClass(String name, String ID, int age, String gender, double LuggageWeight) {
		super(name, ID, age, gender, LuggageWeight);
		LuggageWeightLimit = 23;

		if (LuggageWeight > LuggageWeightLimit)
			System.out.println(
					"##The passenger has surpassed the luggage weight limit, An extra charge of 70 Riyals per kilogram exceeding the limit will apply.##");

	}

	public EconomyClass(EconomyClass p) {
		super(p.name, p.ID, p.age, p.gender, p.LuggageWeight);
		LuggageWeightLimit = 23;

	}

	public String loungAccess() {

		return "loung Access: " + "Not allowed!";

	}

	public String toString() {
		return super.toString() + " " + loungAccess();
	}

}

