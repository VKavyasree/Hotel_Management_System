# 🏨 Hotel Management System (Java Swing)

A GUI-based **Hotel Management System** built using **Java Swing** and **JDBC** for managing hotel operations such as customer registration, room booking, check-in/check-out, billing, staff management, and more.

---

## 🚀 Features

- 🧑‍💼 Add and manage **customers, employees, drivers**
- 🛏️ Add, search, and update **room information**
- 📋 Manage **room bookings, check-ins, and checkouts**
- 🧾 View and manage **customer bills**
- 🧹 View **pickup services**
- 📊 Interactive **dashboard and reception panel**
- 🔐 Login system for staff access

---

## 📁 File Structure

```text
hotel_management_system/
├── AddCustomer.java          # Add new customer details
├── AddDriver.java            # Add new driver records
├── AddEmployee.java          # Add new employee details
├── AddRooms.java             # Add new room information
├── Checkout.java             # Customer checkout functionality
├── Conn.java                 # Database connection class (JDBC)
├── Dashboard.java            # Main dashboard UI
├── Department.java           # Department and staff classification
├── Hotel_Management_System.java # Entry point (Main class)
├── Login.java                # Login UI and logic
├── Pickup.java               # Pickup service management
├── Reception.java            # Reception panel (navigation hub)
├── Room.java                 # View all rooms
├── SearchRoom.java           # Search for available rooms
├── UpdateCheck.java          # Update check-in details
├── UpdateRoom.java           # Update room availability and status
└── Pickup/                   # Additional UI components for Pickup

---

## 🛠️ Tech Stack

- **Java 8+**
- **Swing (GUI)**
- **JDBC (MySQL or SQLite)**
- **NetBeans IDE** (recommended)

---

## 🔧 Setup Instructions

1. **Clone or Download** the repository.
2. Open the project in **NetBeans** or any Java IDE.
3. Make sure your **JDBC driver** (`mysql-connector-java`) is added to the classpath.
4. Set up a **MySQL database** with required tables. (Sample SQL schema can be shared separately.)
5. Run `Hotel_Management_System.java` to launch the application.

---

## 🖼️ UI Screens (Optional)

- Login Page
- Dashboard
- Add/Update Rooms
- Customer Check-in / Checkout
- Room Search
- Pickup and Reception Panels

---

## 📌 Database Tables Required (Sample)

- `customers`
- `employees`
- `drivers`
- `rooms`
- `bookings`
- `departments`

---

## ✍️ Authors

- Developed by **V Kavyasree** 

---

## 📄 License

This project is for educational use only. No commercial use permitted without permission.

---

