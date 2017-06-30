package com.mikosama.app;

import java.util.PriorityQueue;

class BetterParkingLot extends ParkingLot
{
  PriorityQueue<Integer> queue; // to make things potentially more efficient, we'll use a PriorityQueue full of available slots numbers
  // and here's hoping I have an (almost) O(log n) complexity.

	public BetterParkingLot( int size )
	{
		super(size);
    queue = new PriorityQueue<Integer>(size);

    // add all available parking slots in zero-indexed form
    for(int i=0; i <= size; i++) // this is my only problem. It HAS to be O(n) here.
      queue.add(i);
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
