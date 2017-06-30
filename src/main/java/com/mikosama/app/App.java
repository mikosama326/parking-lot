package com.mikosama.app;

public class App
{
	public static void main( String[] args )
	{
		UI ui;

		if(args.length == 1)
		{
			ui = new Shell(args[0]);
			ui.run();
		}
		else if (args.length == 0)
		{
			ui = new Shell();
			ui.run();
		}
		else
		{
			System.out.println("Oops not quite right. " + args.length);
			System.exit(1);
		}

	}
}
