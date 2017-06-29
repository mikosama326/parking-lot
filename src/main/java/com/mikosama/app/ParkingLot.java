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
		//Parking full condition
		if(nextParkingLocation == slots.length)
			return "Sorry, parking lot is full";

		slots[nextParkingLocation++] = incomingCar;
		return "Allocated slot number: " + nextParkingLocation;
	}
}
