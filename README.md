# FCFS Scheduling Simulator

## Overview

This program simulates the **First-Come-First-Serve (FCFS) CPU scheduling algorithm**.
Users input the number of processes along with each process’s **arrival time** and **burst time**.
The program then calculates and displays the **waiting time**, **turnaround time**, and **average values**.

## Requirements

* Java JDK 8 or later
* A Java IDE (IntelliJ, Eclipse) or command line with `javac`

## How to Run

### Option 1: Using an IDE

1. Open the project in your Java IDE.
2. Locate the file containing the `main()` method.
3. Run the program.
4. Follow the input prompts in the dialog boxes.

### Option 2: Using the Command Line

1. Compile the program:

   ```
   javac *.java
   ```
2. Run the program:

   ```
   java Main
   ```
3. Enter the requested values in the dialog prompts.

## Program Flow

1. The program prompts the user for the **number of processes**.
2. The user enters **arrival time** and **burst time** for each process.
3. Processes are placed into a **queue**.
4. The **FCFS algorithm** processes the queue and calculates results.
5. The results and averages are displayed in dialog windows.

## Authors

Brayden Nickel, Drew Temple-Smith, Ethan Pelletier, Kyle Castillo
