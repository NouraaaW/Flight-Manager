# Flight Management System ✈️

## 📌 Project Overview
[cite_start]The **Flight Management System** is a desktop application developed as part of a programming coursework (Phase 2). It allows flight managers to efficiently display passenger data, modify reservations, and manage flight schedules. [cite_start]The system distinguishes between **Business** and **Economy** classes, applying specific rules for luggage and services.

## 💡 Key Features
* **Flight Operations:** Add, cancel, search, and display flights.
* **Passenger Booking:**
    * **Business Class:** Handles VIP status and lounge access.
    * [cite_start]**Economy Class:** Enforces a 23kg luggage limit with extra charge logic.
* [cite_start]**GUI:** A user-friendly interface built with **Java Swing**, featuring input validation and dedicated forms for flight details.
* [cite_start]**Data Persistence:** Implements `saveData` and `loadData` methods using **Java Serialization** to store flight records in `.data` files, ensuring data is saved between sessions[cite: 4846, 4853].

## 🛡️ Exception Handling
The system includes robust error handling as detailed in the project report:
* [cite_start]**Input Validation:** Handles `InputMismatchException` for non-integer inputs (e.g., menus, age)[cite: 4860].
* [cite_start]**Time Validation:** Throws a custom `InvalidTimeFormatException` if the time deviates from HH:MM format[cite: 4863].
* [cite_start]**Booking Constraints:** Throws a custom `PassengerAdditionException` when a flight is full or data is invalid[cite: 4867].
* [cite_start]**File I/O:** Manages `FileNotFoundException`, `IOException`, and `ClassNotFoundException` during data loading/saving[cite: 4874, 4882].

## 🛠 Technical Architecture
* **Language:** Java
* [cite_start]**GUI:** Java Swing (JFrame, GroupLayout)[cite: 4886].
* **Concepts:** Polymorphism, Inheritance, Exception Handling, File I/O (Object Streams).
