package com.mikosama.app;

class Slot
{

}

class ParkingLot
{
	int nextParkingLocation = 0;
	Car[] slots; //are we really using an array for this?

	ParkingLot(int size)
	{
		slots = new Car[size];
	}

}

class Car
{

}

class Shell
{
	BufferedReader br = null;

	Shell(String filename)
	{
		try
		{
			br = new BufferedReader(new FileReader(filename);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	Shell()
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run()
	{

	}

}

public class App
{
public static void main( String[] args )
{
System.out.println( "Hello World!" );
}
}
