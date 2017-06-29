package com.mikosama.app;

import java.util.ArrayList;

class ParkingLot
{
	int nextParkingLocation = 0;
	Car[] slots; //are we really using an array for this?

	public ParkingLot( int size )
	{
		slots = new Car[size];
	}

	public String park(Car incomingCar)
	{
		// Parking full?
		if(nextParkingLocation == slots.length)
			return "Sorry, parking lot is full";

		// Guess not.
		int parkingLocation = nextParkingLocation; // save this for later
		slots[parkingLocation] = incomingCar; // park the car
		nextParkingLocation = getNextParkingLocation(parkingLocation); // get the next closest parking location to the entrance
		return "Allocated slot number: " + (++parkingLocation);// printing in 1-index so.
	}

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

	public String searchSlotByRegistrationNo(String registrationNo)
	{
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null && slots[i].getRegistrationNo().equals(registrationNo) )
				return ""+(i+1);
		}
		return "Not found";
	}

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

	protected ArrayList<Integer> searchByColor(String color)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null && slots[i].getColor().equals(color) )
				results.add(i);
		}
		return results;
	}

	public String status()
	{
		String answer = "Slot No.\tRegistration No\tColour\n";
		for(int i = 0; i < slots.length ; i++)
		{
			if( slots[i] != null )
				answer += (i+1) + "\t" + slots[i].getRegistrationNo() + "\t" + slots[i].getColor() + "\n";
		}
		return answer;
	}

}
