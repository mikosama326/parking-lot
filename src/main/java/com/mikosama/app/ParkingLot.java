package com.mikosama.app;

import java.util.ArrayList;

/*
** ParkingLot is a class which performs all the required operations of a parking lot. Each method returns String messages after completion.
*/
class ParkingLot
{
	private Car[] slots; //to make deletions easier.

	private int nextParkingLocation = 0; // a pointer that'll help us find the next place to park easier.

	/*
	** Our one and only constructor.
	*/
	public ParkingLot( int size )
	{
		slots = new Car[size];
	}

	/*
	** Meant just to help check that the parking lot creation happened correctly.
	*/
	public String create()
	{
		return "Created a parking lot with " + slots.length + " slots";
	}

	/*
	** To park a car in the parking lot
	*/
	public String park(Car incomingCar)
	{
		int parkingLocation = getNextParkingLocation(nextParkingLocation); //get the best place to park
		nextParkingLocation = parkingLocation; // to store this value for later.

		// Parking full?
		if(!(parkingLocation >= 0) || !(parkingLocation < slots.length))
			return "Sorry, parking lot is full";

		// Guess not.
  	slots[parkingLocation] = incomingCar; // park the car
		return "Allocated slot number: " + (++parkingLocation);// printing in 1-index so.
	}

	/*
	** To simulate a car leaving the parking lot
	*/
	public String leave(int slotNo) // slotNo is 1-indexed
	{
		slotNo--; // converting to zero-indexed form to make our life easy.

		// unclear whether it's a good idea to do this. But hey, idiot-proof input.
		if(slotNo < 0 || slotNo >= slots.length)
			return "Invalid slot number";

		// returns message if there's no car at that slot.
		if(slots[slotNo] == null)
			return "That slot is empty";

		// all idiot-proofing complete. Moving on...
		slots[slotNo] = null; // get rid of that car.

		// update the nextParkingLocation pointer only if the newly-empty slot is closer to the entrance
		updateAvailableParkingLocations(slotNo);

		return "Slot number " + (++slotNo) + " is free";//using 1-index for printing
	}

	/*
	** Search the parking lot for a car by Registration Number and return the slot number
	*/
	public String searchSlotByRegistrationNo(String registrationNo)
	{
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null && slots[i].getRegistrationNo().equals(registrationNo) )
				return ""+(i+1);
		}
		return "Not found";
	}

	/*
	** Search the parking lot for a car by color and return the slot numbers of those cars
	*/
	public String searchSlotsByColor(String color)
	{
		ArrayList<Integer> results = searchByColor(color);

		if(results.size() == 0)
			return "Not found";

		String answer = "";
		for(Integer index : results)
			answer = answer + (index+1) + ", ";

		answer = answer.substring(0,answer.length()-2); // cutting off the last ", "

		return answer;
	}

	/*
	** Search the parking lot for a car by color and return the registration numbers of those cars
	*/
	public String searchRegistrationNosByColor(String color)
	{
		ArrayList<Integer> results = searchByColor(color);

		if(results.size() == 0)
			return "Not found";

		String answer = "";
		for(Integer index : results)
			answer = answer + (slots[index].getRegistrationNo()) + ", "; // basically the only line that's different.

		answer = answer.substring(0,answer.length()-2); // cutting off the last ", "

		return answer;
	}

	/*
	** Returns an ArrayList full of slot numbers of cars which color 'color'
	*/
	private ArrayList<Integer> searchByColor(String color)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null && slots[i].getColor().equals(color) )
				results.add(i);
		}
		return results;
	}

	/*
	** Prints the status of the parking lot in a nice tabular form
	*/
	public String status()
	{
		String answer = "Slot No.\tRegistration No\tColour\n";
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null )
				answer += (i+1) + "\t" + slots[i].getRegistrationNo() + "\t" + slots[i].getColor() + "\n";
		}
		return answer.substring(0,answer.length()-1); //removing the last "\n"
	}

	/*
	** Implementation of the parking lot next-pointer updations
	*/
	protected int getNextParkingLocation(int initalPosition)
	{
		// ugh. so ugly. Linear check for the next empty slot. At least we're not starting from slots[0]?
		int pos;
		for(pos = initalPosition; pos < slots.length && slots[pos] != null; pos++);
		return pos;
	}

	protected void updateAvailableParkingLocations(int availableSlot)
	{
		if( availableSlot < nextParkingLocation )
			nextParkingLocation = availableSlot;
	}

}
