package com.mikosama.app;

import java.util.Comparator;
import java.util.PriorityQueue;

class BetterParkingLot extends ParkingLot
{
  PriorityQueue<Integer> queue;

	public BetterParkingLot( int size )
	{
		super(size);
    queue = new PriorityQueue<Integer>(size);

    // add all available parking slots in zero-indexed form
    for(int i=0; i < size; i++)
      queue.add(i);
	}

  @Override
  public String park(Car incomingCar)
	{
    // Parking full?
		if(queue.size() == 0)
			return "Sorry, parking lot is full";

		// Guess not.
    int parkingLocation = queue.poll();// get the best place to park
  	slots[parkingLocation] = incomingCar; // park the car
		return "Allocated slot number: " + (++parkingLocation);// printing in 1-index so.
	}

  @Override
	protected int getNextParkingLocation(int initalPosition)
	{
		int pos = queue.poll();
		return pos;
	}

  @Override
  protected void updateAvailableParkingLocations(int availableSlot)
  {
    queue.add(availableSlot);
  }
}
