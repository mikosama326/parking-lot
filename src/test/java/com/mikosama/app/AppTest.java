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
     * Tests :-)
     */

    // inital super basic test
    public void testThatThisRuns()
    {
        assertTrue( true );
    }

    // test that the Shell object can be created.
    public void testInteractiveShellCreation()
    {
      Shell shell = new Shell();

      assertTrue( shell != null );
    }

    // test that the Shell can open a file.
    public void testFileShellCreation()
    {
      Shell shell = new Shell("src/test/java/com/mikosama/app/shelltestfile");

      assertTrue( shell != null );
    }

    // test that a Car object is created correct
    public void testCarCreation()
    {
      Car car = new Car("KA-01-HH-1234","White");
      String recievedColor = car.getColor();
      String recievedRegistrationNo = car.getRegistrationNo();

      assertTrue( recievedColor == "White" && recievedRegistrationNo == "KA-01-HH-1234" );
    }

    // test that a Parking Lot object can be created
    public void testParkingLotCreation()
    {
      ParkingLot lot = new ParkingLot(6);

      assertTrue( true );
    }

    // basic parking functionality test
    public void testBasicPark()
    {
      ParkingLot lot = new ParkingLot(3);
      String result = lot.park(new Car("KA-01-HH-1234","White"));

      assertTrue( result.equals("Allocated slot number: 1") );
    }

    // now we check that parking logic works right
    public void testParkMore()
    {
      ParkingLot lot = new ParkingLot(3);

      // this part we checked already
      String result = lot.park(new Car("KA-01-HH-1234","White"));
      assertTrue( result.equals("Allocated slot number: 1") );

      // checking that the pointer is incremented right
      result = lot.park(new Car("KA-01-HH-9999","White"));
      assertTrue( result.equals("Allocated slot number: 2") );

      result = lot.park(new Car("KA-01-BB-0001","Black"));
      assertTrue( result.equals("Allocated slot number: 3") );

      // parking full condition check
      result = lot.park(new Car("KA-01-HH-7777","White"));
      assertTrue( result.equals("Sorry, parking lot is full") );
    }

    // test basic leaving functionality
    public void testBasicLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      String result = lot.leave(1);

      assertTrue( result.equals("Slot number 1 is free") );
    }

    // check that the system catches situations where people try to empty an invalid/empty slot
    public void testIdiotProofingLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      // Invalid slot case (boundary check, I guess)
      String result = lot.leave(-1);
      assertTrue( result.equals("Invalid slot number") );

      result = lot.leave(4);
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
