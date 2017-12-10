# Parking Lot Simulation

A coding assignment for a freshers' job recruitment. Written in Java, meant to be compiled and run on Linux. Developed using TDD.

The goal is to simulate a parking lot with a lot-allocation system that assigns an incoming car the lot with the lowest number. It has a Shell-based UI with commands for each car as it enters.

## How to build

You'll need Maven and JUnit, as well as the Java JDK and JRE set up.

Then, run the 'parking_lot' file in the the root directory of this application with an option input file as argument.

## Working and features

- The main business logic of the entire application runs in the ParkingLot class.
- The UI interface is meant to help run the application. Here, we use the Shell UI.
- The Car class is meant to hold information about the car. Here, we care about its color and registration number.
- BetterParkingLot is a class that improves the parking and leaving efficiency of the parking lot. The idea hit me only after I wrote the initial ParkingLot class.
- Added in a 'help' command that will print all available commands and their use.
- Assumed a few error messages that may pop up on invalid input.

## Some design assumptions, missing features and future improvement

- We assume there is only one entrance to the parking lot and that there is only one parking lot to be controlled by our application.
- Regular expression check for valid Registration Numbers on each car has not been implemented.
- Ticketing system has not been implemented completely, though an interface has been written for future use. For our current application, the ticketing logic was unnecessary.
- Idiot-proofing of individual commands (eg. printing use of each command or checking adherance to syntax) has not been implemented.
- Have no implemented a little shell prompt to make the shell command-writing more legible.
- Have not allowed for printing output to a file instead of STDOUT.
- Code is not thread safe.
- No support for multiple parking lots per shell or multiple shells.
