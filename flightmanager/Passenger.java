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
import java.io.*;
import java.util.*;

public abstract class Passenger implements Serializable {

	protected String name, ID, gender;
	protected int age;
	protected double LuggageWeight;

	public Passenger(String name, String ID, int age, String gender, double LuggageWeight) {
		this.name = name;
		this.ID = ID;
		this.age = age;
		this.gender = gender;
		this.LuggageWeight = LuggageWeight;
	}

	public String toString() {
		return "Passenger's name: " + this.name + " -ID: " + this.ID + " -age: " + this.age + " -luggage weight: "
				+ this.LuggageWeight;
	}

	public abstract String loungAccess();

	public String getID() {
		return ID;
	}

}

