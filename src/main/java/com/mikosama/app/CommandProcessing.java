package com.mikosama.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

class Shell
{
	BufferedReader br = null;

	public Shell( String filename )
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

	public Shell()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run()
	{
		String line;
    try
		{
			while ((line = br.readLine()) != null)
			{
				parseCommand( line );
    	}
		}
		catch( IOException e )
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void parseCommand( String line )
	{
		//okay, this part is going to be a pain.
	}
}
