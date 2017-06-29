package com.mikosama.app;

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
		slots[nextParkingLocation++] = incomingCar;
		return "Allocated slot number: " + nextParkingLocation;
	}

	public String leave(int slotNo) // slotNo is 1-indexed
	{
		slotNo--; // converting to zero-indexed form to make our life easy.

		// unclear whether it's a good idea to do this. But hey. Idiot-proof input.
		if(slotNo < 0 || slotNo >= slots.length)
			return "Invalid slot number";

		// returns message if there's no car at that slot.
		if(slots[slotNo] == null)
			return "That slot is empty";

		// all idiot-proofing complete. Moving on...
		slots[slotNo] = null; // get rid of that car.

		// update the nextParkingLocation pointer only if the newly-empty slot is closer to the entrance
		if( slotNo < nextParkingLocation )
			nextParkingLocation = slotNo;

		return "Slot number " + (++slotNo) + " is free";
	}
}
