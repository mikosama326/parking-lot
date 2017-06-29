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

class Car
{
	String registrationNo;
	String color;

	public Car(String registrationNo,String color)
	{
			this.registrationNo = registrationNo;
			this.color = color;
	}
}

class Shell
{
	BufferedReader br = null;

	public Shell( String filename )
	{
		try
		{
			br = new BufferedReader(new FileReader(filename);
		}
		catch( IOException e )
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	public Shell()
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		catch( IOException e )
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run()
	{
		String line;
    while ((line = br.readLine()) != null)
		{
       parseCommand( line );
    }
	}

	private void parseCommand( String line )
	{
		//okay, this part is going to be a pain.
	}
}

public class App
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
	}
}
