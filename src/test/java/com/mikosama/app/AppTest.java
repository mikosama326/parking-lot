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

      assertEquals( result , "Allocated slot number: 1" );
    }

    // now we check that parking logic works right
    public void testParkMore()
    {
      ParkingLot lot = new ParkingLot(3);

      // this part we checked already
      String result = lot.park(new Car("KA-01-HH-1234","White"));
      assertEquals( result , "Allocated slot number: 1" );

      // checking that the pointer is incremented right
      result = lot.park(new Car("KA-01-HH-9999","White"));
      assertEquals( result , "Allocated slot number: 2" );

      result = lot.park(new Car("KA-01-BB-0001","Black"));
      assertEquals( result , "Allocated slot number: 3" );

      // parking full condition check
      result = lot.park(new Car("KA-01-HH-7777","White"));
      assertEquals( result , "Sorry, parking lot is full" );
    }

    // test basic leaving functionality
    public void testBasicLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      String result = lot.leave(1);

      assertEquals( result , "Slot number 1 is free" );
    }

    // check that the system catches situations where people try to empty an invalid/empty slot
    public void testIdiotProofingLeave()
    {
      ParkingLot lot = new ParkingLot(3);
      lot.park(new Car("KA-01-HH-1234","White"));

      // Invalid slot case (boundary check, I guess)
      String result = lot.leave(-1);
      assertEquals( result , "Invalid slot number" );

      result = lot.leave(4);
      assertEquals( result , "Invalid slot number" );

      // Empty slot case
      result = lot.leave(2);
      assertEquals( result , "That slot is empty" );

      // A slot where a car has already left
      result = lot.leave(1);
      assertEquals( result , "Slot number 1 is free" ); // just a double-check

      result = lot.leave(1);
      assertEquals( result , "That slot is empty" );
    }

    // if a car leaves then a new car will probably want to park there instead of at the end
    public void testParkingLocationChangeAfterLeaveTrue()
    {
      ParkingLot lot = new ParkingLot(6);

      // first we park some cars
      lot.park(new Car("KA-01-HH-1234","White"));
      lot.park(new Car("KA-01-HH-9999","White"));
      lot.park(new Car("KA-01-BB-0001","Black"));
      lot.park(new Car("KA-01-HH-7777","White"));

      // now we let one of these cars leave
      lot.leave(2);

      // and then we check that the next car to be parked occupies that space
      String result = lot.park(new Car("KA-01-HH-2701","Blue"));
      assertEquals( result , "Allocated slot number: 2" );
    }
}
