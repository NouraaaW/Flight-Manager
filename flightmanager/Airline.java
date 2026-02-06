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

public class Airline implements Serializable {
	private int numOfFlights;
	private String name;
	public Flight[] flights;

	public Airline(String name) {
		numOfFlights = 0;
		this.name = name;
		flights = new Flight[100];
	}

	public boolean addFlight(Flight f) {
		if (numOfFlights < flights.length) {
			flights[numOfFlights++] = f;
			return true;
		}
		return false;
	}

	public Flight searchFlight(String flightNo) {
		for (Flight f : flights) {
			if (f != null && f.getFlightNo().equals(flightNo)) {
				return f;
			}
		}
		return null;
	}

	public void cancelFlight(String flightNo) {
		for (int i = 0; i < numOfFlights; i++) {
			if (flights[i] != null && flights[i].getFlightNo().equals(flightNo)) {
				flights[i] = flights[numOfFlights - 1];
				flights[numOfFlights - 1] = null;
				numOfFlights--;
				System.out.println("Flight " + flightNo + " has been canceled.");
				return;
			}
		}
		System.out.println("Flight " + flightNo + " not found.");
	}

	public String toString() {

		String str = "Airline Name: -" + name + "- Number Of Flights: " + numOfFlights + "\n---------------------------"
				+ "\nFlights: ";
		String flightsString = "";

		if (numOfFlights > 0) {
			for (int i = 0; i < numOfFlights; i++) {

				flightsString += flights[i].toString() + "\n";

			}
		} else {
			flightsString += "There is no flight yet\n";
		}

		return str + flightsString;

	}



	public int getNumOfFlights() {
		return numOfFlights;
	}

	public void setNumOfFlights(int numOfFlights) {
		this.numOfFlights = numOfFlights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flight[] getFlights() {
		return flights;
	}

	public void setFlights(Flight[] flights) {
		this.flights = flights;
	}

}
