/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightmanager;
import java.io.*;
import java.util.*;

/**
 *
 * @author منوري
 */
public class FlightManager {
	public static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        	System.out.println("Welcome to the Flight Manager system!");

		String airlineName;
		System.out.println("What is the name of the Airline? ");
		airlineName = scanner.nextLine();
		Airline airline = new Airline(airlineName);

		loadData(airline);

		int choice;
		do {

			System.out.println("\n***********************************");
			System.out.println("Choose one of the options:");
			System.out.println("1. Add a flight");
			System.out.println("2. Cancel a flight");
			System.out.println("3. Search for a flight");
			System.out.println("4. Display all flights");
			System.out.println("5. Add a Passenger to a specified flight");
			System.out.println("6. Search for a Passenger in a specified flight");
			System.out.println("7. Remove a Passenger from a specified flight");
			System.out.println("8. Display all Passengers in a specified flight");
			System.out.println("9. Exit");
			System.out.println("**********************************\n");

			while (true) {
				try {
					System.out.print("Enter your choice: ");
					choice = scanner.nextInt();
					break;
				} catch (InputMismatchException a) {
					System.out.println("Only digits, try again:");
					String str;
					str = scanner.next();
				}
			}

			switch (choice) {
			case 1:
				String flightNo;
				try {
					System.out.println("Adding a new flight:");
					System.out.print("Enter flight number: ");
					flightNo = scanner.next();
					System.out.print("Enter destination: ");
					String destination = scanner.next();
					System.out.print("Enter departure time (HH:MM): ");
					String departureTime = scanner.next();
					System.out.print("Enter arrival time (HH:MM): ");
					String arrivalTime = scanner.next();

					if (!isValidTimeFormat(departureTime) || !isValidTimeFormat(arrivalTime)) {
						throw new InvalidTimeFormatException("Invalid time format. Please use HH:MM format.");
					}

					airline.addFlight(new Flight(flightNo, destination, departureTime, arrivalTime));
					System.out.println("Flight added successfully.");
				} catch (InvalidTimeFormatException e) {
					System.out.println("Error adding flight: " + e.getMessage());
				}
				break;
			case 2:
				System.out.println("Canceling a flight:");
				System.out.print("Enter flight number to cancel: ");
				flightNo = scanner.next();
				airline.cancelFlight(flightNo);
				break;
			case 3:
				System.out.println("Searching for a flight:");
				System.out.print("Enter flight number to search: ");
				flightNo = scanner.next();
				Flight flight = airline.searchFlight(flightNo);
				if (flight != null) {
					System.out.println("Flight found:");
					System.out.println(flight);
					System.out.println("---------------------------");
				} else {
					System.out.println("Flight not found.");
				}
				break;
			case 4:
				System.out.println("Displaying all flights:");
				System.out.println(airline.toString());
				System.out.println("---------------------------");
				break;

			case 5:
				System.out.println("Flight number: ");
				flightNo = scanner.next();

				if (airline.searchFlight(flightNo) != null) {
					try {
						System.out.println("Passenger's name: ");
						String name = scanner.next();
						System.out.println("Passenger's ID: ");
						String id = scanner.next();
						System.out.println("Passenger's age: ");
						int age = scanner.nextInt();
						System.out.println("Passenger's gender: ");
						String gender = scanner.next();
						System.out.println("Luggage Weight: ");
						double LuggageWeight = scanner.nextDouble();
						System.out.println("Business or Economy class? e/b");
						char c = scanner.next().charAt(0);
						flight = airline.searchFlight(flightNo);

						switch (c) {
						case 'B':
						case 'b':
							BusinessClass p = new BusinessClass(name, id, age, gender, LuggageWeight, false);
							if (flight.addPassenger(p)) {
								System.out.println(p.loungAccess());
								System.out.println("---------------------------");
								System.out.println("The passenger has been added successfully!");
							} else {
								throw new PassengerAdditionException("Failed to add passenger.");
							}
							break;
						case 'E':
						case 'e':
							EconomyClass p1 = new EconomyClass(name, id, age, gender, LuggageWeight);
							if (flight.addPassenger(p1)) {
								System.out.println(p1.loungAccess());
								System.out.println("---------------------------");
								System.out.println("The passenger has been added successfully!");
							} else {
								throw new PassengerAdditionException("Failed to add passenger.");
							}
							break;
						default:
							System.out.println("Invalid input, Unable to add the passenger, Please try again!");
						}
					} catch (PassengerAdditionException e) {
						System.out.println("Error adding passenger: " + e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("Invalid input format: " + e.getMessage());
					}
				} else {
					System.out.println("Flight not found.");
				}
				break;

			case 6:
				System.out.println("Flight number: ");
				flightNo = scanner.next();
				flight = airline.searchFlight(flightNo);
				if (airline.searchFlight(flightNo) != null) {
					System.out.println("Passenger's ID: ");
					String id = scanner.next();
					if (flight.searchPassenger(id) != null) {
						System.out.println("---------------------------");
						System.out.println("Passenger information: ");
						System.out.println(flight.searchPassenger(id).toString());
						System.out.println("---------------------------");
					} else
						System.out.println("Passenger " + id + " not found.");
				} else
					System.out.println("Flight not found.");

				break;
			case 7:
				System.out.println("Flight number: ");
				flightNo = scanner.next();
				if (airline.searchFlight(flightNo) != null) {
					System.out.println("Passenger's ID: ");
					String id = scanner.next();
					flight = airline.searchFlight(flightNo);
					if (flight != null && flight.removePassenger(id))
						System.out.println("Passenger " + id + " has been Removed.");
					else
						System.out.println("Passenger " + id + " not found.");
				} else
					System.out.println("Flight not found.");

				break;
			case 8:
				System.out.println("Flight number: ");
				flightNo = scanner.next();
				flight = airline.searchFlight(flightNo);
				if (flight != null) {
					System.out.println(flight.AllPassInfo());
					System.out.println("---------------------------");
				} else
					System.out.println("Flight not found.");
				break;
			case 9:
				SaveData(airline);
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number from 1 to 8, 9 to exit");
			}

		} while (choice != 9);

		System.exit(0);

	}

	public static boolean isValidTimeFormat(String time) throws InvalidTimeFormatException {
		if (time.length() != 5) {
			throw new InvalidTimeFormatException("Invalid time format. Please use HH:MM format.");
		}

		for (int i = 0; i < 5; i++) {
			if (i == 2) {
				if (time.charAt(i) != ':') {
					throw new InvalidTimeFormatException("Invalid time format. Please use HH:MM format.");
				}
			} else {
				if (!Character.isDigit(time.charAt(i))) {
					throw new InvalidTimeFormatException("Invalid time format. Please use HH:MM format.");
				}
			}
		}

		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3));

		if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
			throw new InvalidTimeFormatException(
					"Invalid time format. Hours must be between 00 and 23, minutes between 00 and 59.");
		}

		return true;
	}

	public static void SaveData(Airline airline) {

		try {
			File out = new File("" + airline.getName() + ".data");
			FileOutputStream fos = new FileOutputStream(out);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Flight passListMain[] = new Flight[airline.getNumOfFlights()];
			for (int i = 0; i < airline.getNumOfFlights(); i++) {
				passListMain[i] = airline.getFlights()[i];
				oos.writeObject(passListMain[i]);
			}

			oos.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error saving data!! " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}

	public static void loadData(Airline airline) {
		try {
			Flight f;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("" + airline.getName() + ".data"));
			try {
				while (true) {
					f = (Flight) in.readObject();
					airline.addFlight(f);
				}
			} catch (EOFException endOfFileException) {
				System.out.println("Data loaded successfully.");
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found: " + e.getMessage());
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An error occurred while reading: " + e.getMessage());
		}
	}
}


    
    

