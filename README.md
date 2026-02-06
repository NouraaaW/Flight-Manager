# Flight Management System ✈️

## 🚀 Project Overview
The Flight Management System is a desktop application designed to streamline airline operations. It allows users to manage flight schedules, handle passenger bookings, and differentiate between travel classes with specific rules for luggage and services.

The system features a Graphical User Interface (GUI) and ensures data persistence through file serialization.

## 🔑 Key Features
* **Flight Operations:** Add, cancel, search, and display flights with details (Destination, Time, Flight No).
* **Passenger Management:**
    * **Business Class:** Handles VIP status and lounge access logic.
    * **Economy Class:** Enforces a 23kg luggage weight limit and calculates extra charges for overweight bags.
* **Data Persistence:** Automatically saves and loads system data using `saveData` and `loadData` methods (Serialization) to ensure no data is lost between sessions.
* **Validation:** Custom exception handling for time formats (`InvalidTimeFormatException`) and passenger addition constraints (`PassengerAdditionException`).

## 🛠 Tech Stack
* **Language:** Java.
* **GUI:** Java Swing (JFrame).
* **Core Concepts:** OOP (Polymorphism, Inheritance), Exception Handling, File I/O (Serialization).
