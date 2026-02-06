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

public class Flight implements Serializable {
	private String flightNo;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private int numOfPass;
	public Passenger[] passList;

	public Flight(String flightNo, String destination, String departureTime, String arrivalTime) {
		this.flightNo = flightNo;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		numOfPass = 0;
		passList = new Passenger[150];
	}

	public boolean addPassenger(Passenger p) {
		if (numOfPass < passList.length) {
			if (p instanceof BusinessClass) {
				passList[numOfPass] = new BusinessClass((BusinessClass) p);
			} else if (p instanceof EconomyClass) {
				passList[numOfPass] = new EconomyClass((EconomyClass) p);
			}

			numOfPass++;
			return true;
		}
		System.out.println("All seats on the plane are occupied, Please search for alternative flights.");
		return false;
	}

	public boolean removePassenger(String id) {
		for (int i = 0; i < numOfPass; i++) {
			if (passList[i].getID().equals(id)) {
				passList[i] = passList[numOfPass - 1];
				passList[numOfPass - 1] = null;
				numOfPass--;
				return true;
			}
		}
		return false;
	}

	public Passenger searchPassenger(String id) {
		for (int i = 0; i < numOfPass; i++) {
			if (passList[i].getID().equals(id)) {
				return passList[i];
			}
		}
		return null;
	}

	public String toString() {
		return "\n---------------------------\n" + "Flight Number: " + getFlightNo() + " Destination: " + destination
				+ "\n" + "Departure Time= " + departureTime + "------>" + " Arrival Time= " + arrivalTime;
	}

	public String AllPassInfo() {
		String AllPassInfo = "";

		if (numOfPass > 0) {
			for (int i = 0; i < numOfPass; i++) {
				AllPassInfo += "\n" + "---------------------------" + "\n" + (passList[i].toString());
			}
		} else
			AllPassInfo = "There are no passengers on this flight.";

		return AllPassInfo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getNumOfPass() {
		return numOfPass;
	}

	public void setNumOfPass(int numOfPass) {
		this.numOfPass = numOfPass;
	}

	public Passenger[] getPassList() {
		return passList;
	}

	public void setPassList(Passenger[] passList) {
		this.passList = passList;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

}

