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
      ParkingLot PLot = new ParkingLot(6);

      assertTrue( true );
    }

}
