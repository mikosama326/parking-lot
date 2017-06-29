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
}
