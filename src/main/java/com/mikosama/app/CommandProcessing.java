package com.mikosama.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.PrintWriter;

/*
** An interface for any UI for the Parking Lot system.
*/
interface UI
{
	public void run();
}

/*
** For this application, we're using a text-based command-line shell.
*/
class Shell implements UI
{
	BufferedReader br = null; // to handle input
	ParkingLot lot; // for now, we're assuming that there's only one parking lot per Shell

	public Shell( String filename) // taking input from a file
	{
		try
		{
			br = new BufferedReader(new FileReader(filename));
		}
		catch( IOException e )
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Shell() // taking input from shell line-by-line
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/*
	** This is the function which we call to run the shell.
	*/
	@Override
	public void run()
	{
		String line;
    try
		{	/*
			** Ideally we'd like to put some sort of prompt like ">>" or something to make it more legible, but it might get in the way of automatic testing.
			*/
			while ((line = br.readLine()) != null && !line.equals(""))
			{
				String result = parseCommand( line );
				System.out.println(result);
    	}
		}
		catch( IOException e )
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	/*
	** The string command parsing and execution
	*/
	private String parseCommand( String line )
	{
		String[] args = line.split( "\\s" ); // split the line by whitespace

		// all the supported commands
		if( "create_parking_lot".equals(args[0]) ) // Use: create_parking_lot <parking lot size>
		{
			lot = new BetterParkingLot(Integer.parseInt(args[1]));
			return lot.create();
		}

		else if( "park".equals(args[0]) ) // Use: park <registration no> <color>
		{
			Car incomingCar = new Car( args[1],args[2] );
			return lot.park( incomingCar );
		}

		else if( "leave".equals(args[0]) ) // Use: leave <slot no>
		{
			return lot.leave( Integer.parseInt( args[1] ) );
		}

		else if( "status".equals(args[0]) ) // Use: status
		{
			return lot.status();
		}

		else if( "registration_numbers_for_cars_with_colour".equals(args[0]) ) // Use: registration_numbers_for_cars_with_colour <color>
		{
				return lot.searchRegistrationNosByColor( args[1] );
		}

		else if( "slot_numbers_for_cars_with_colour".equals(args[0]) ) // Use: slot_numbers_for_cars_with_colour <color>
		{
			return lot.searchSlotsByColor( args[1] );
		}

		else if( "slot_number_for_registration_number".equals(args[0]) ) // Use: slot_number_for_registration_number <registration no>
		{
			return lot.searchSlotByRegistrationNo( args[1] );
		}

		else if( "help".equals(args[0]) ) // a 'help' command to help people out. Meant to be easy to read and edit in code. Ideally, we'd like this to be automatically generated somehow.
		{
			String answer = "Supported Commands:\n";
			answer += "create_parking_lot <parking lot size>\n";
			answer += "park <registration no> <color>\n";
			answer += "leave <slot no>\n";
			answer += "status\n";
			answer += "registration_numbers_for_cars_with_colour <color>\n";
			answer += "slot_numbers_for_cars_with_colour <color>\n";
			answer += "slot_number_for_registration_number <registration no>\n";
			answer += "help\n";
			answer += "You can exit using ctrl-D.\n";
			return answer;
		}
			return "Unsupported command.";
	}
}
