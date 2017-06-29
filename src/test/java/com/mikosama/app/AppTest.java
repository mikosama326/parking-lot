package com.mikosama.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testThatThisRuns()
    {
        assertTrue( true );
    }

    public void testInteractiveShellCreation()
    {
      Shell shell = new Shell();

      assertTrue( true );
    }

    public void testFileShellCreation()
    {
      Shell shell = new Shell("src/test/java/com/mikosama/app/shelltestfile");

      assertTrue( true );
    }

    public void testCarCreation()
    {
      Car car = new Car("KA-01-HH-1234","White");
      String recievedColor = car.getColor();
      String recievedRegistrationNo = car.getRegistrationNo();

      assertTrue( recievedColor == "White" && recievedRegistrationNo == "KA-01-HH-1234" );
    }

    public void testParkingLotCreation()
    {
      ParkingLot lot = new ParkingLot(6);

      assertTrue( true );
    }

    public void testBasicPark()
    {
      ParkingLot lot = new ParkingLot(3);
      String result = lot.park(new Car("KA-01-HH-1234","White"));

      assertTrue( result.equals("Allocated slot number: 1") );
    }

    public void testParkMore()
    {
      ParkingLot lot = new ParkingLot(3);

      String result = lot.park(new Car("KA-01-HH-1234","White"));
      assertTrue( result.equals("Allocated slot number: 1") );

      result = lot.park(new Car("KA-01-HH-9999","White"));
      assertTrue( result.equals("Allocated slot number: 2") );

      result = lot.park(new Car("KA-01-BB-0001","Black"));
      assertTrue( result.equals("Allocated slot number: 3") );

      result = lot.park(new Car("KA-01-HH-7777","White"));
      assertTrue( result.equals("Sorry, parking lot is full") );
    }

    public void testBasicLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      String result = lot.leave(1);

      assertTrue( result.equals("Slot number 1 is free") );
    }

    public void testIdiotProofingLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      // Invalid case
      String result = lot.leave(-1);
      assertTrue( result.equals("Invalid slot number") );

      // Empty slot case
      result = lot.leave(2);
      assertTrue( result.equals("That slot is empty") );

      // A slot where a car has already left
      result = lot.leave(1);
      assertTrue( result.equals("Slot number 1 is free") ); // just a double-check

      result = lot.leave(1);
      assertTrue( result.equals("That slot is empty") );
    }
}
