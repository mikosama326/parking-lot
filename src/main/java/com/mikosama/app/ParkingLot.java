package com.mikosama.app;

class ParkingLot
{
	int nextParkingLocation = 0;
	Car[] slots; //are we really using an array for this?

	public ParkingLot( int size )
	{
		slots = new Car[size];
	}

}
