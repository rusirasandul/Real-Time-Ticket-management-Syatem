# Real-Time Event Ticketing System

## Project Overview
The **Real-Time Event Ticketing System** is a robust, concurrent application designed to simulate a dynamic ticketing environment using modern web technologies. The system leverages the **Producer-Consumer pattern** to handle ticket releases and purchases concurrently while maintaining data integrity.

---

## Technology Stack
- **Backend**: Spring Boot
- **Frontend**: Angular
- **Database**: H2 (In-memory database)
- **Concurrency**: Java Multithreading

---

## Features
- Concurrent ticket releases by vendors.
- Simultaneous ticket purchases by customers.
- Real-time ticket availability tracking.
- Configurable system parameters.
- Thread-safe operations with synchronization.

---

## Prerequisites
Ensure the following software is installed on your system:
- **Java Development Kit (JDK)**: 11 or higher.
- **Node.js and npm**: Required for Angular.
- **Angular CLI**: For frontend development.
- **Maven** or **Gradle**: For building and running the backend.

---

## Installation and Setup

### Backend (Spring Boot)
1. Clone the repository:
   ```bash
   git clone https://github.com/[YOUR-USERNAME]/real-time-ticketing-system.git
   cd real-time-ticketing-system

Backend (Spring Boot)

Clone the repository:
bashCopygit clone https://github.com/[YOUR-USERNAME]/real-time-ticketing-system.git
cd real-time-ticketing-system

Build the Spring Boot application:
bashCopy# If using Maven
mvn clean install

# If using Gradle
gradle clean build

Run the backend:
bashCopy# Maven
mvn spring-boot:run

# Gradle
gradle bootRun


Frontend (Angular)

Navigate to the frontend directory:
bashCopycd frontend

Install dependencies:
bashCopynpm install

Start the development server:
bashCopyng serve

Open your browser and navigate to http://localhost:4200

Configuration
The application allows configuration of the following parameters:

Total Number of Tickets
Ticket Release Rate
Customer Retrieval Rate
Maximum Ticket Capacity

Configure these in the application configuration interface or properties file.
Key Components

Ticket Vendor (Producer): Simulates ticket vendors releasing tickets
Customer (Consumer): Simulates customers purchasing tickets
Ticket Pool: Manages concurrent ticket additions and removals
Synchronization Mechanisms: Ensures thread-safe operations

Testing
Run automated tests:
bashCopy# Maven
mvn test

# Gradle
gradle test
Advanced Features

Priority Customer Handling
Real-time Analytics Dashboard
Dynamic Vendor/Customer Management

Architectural Patterns

Producer-Consumer Pattern
Multithreading
Synchronization

Challenges and Solutions

Implemented thread-safe ticket pool using synchronized methods
Used Java concurrency utilities to manage race conditions
Developed robust error handling and logging mechanisms

Contributing

Fork the repository
Create your feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request

License
Distributed under the MIT License. See LICENSE for more information.
Contact
[Your Name] - [your-email@example.com]
Project Link: https://github.com/[YOUR-USERNAME]/real-time-ticketing-system
Acknowledgments

Spring Boot Documentation
Angular Team
Java Concurrency Experts
