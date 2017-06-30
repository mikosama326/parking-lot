package com.mikosama.app;

/*
** Class that represents as ticket to be issued when a car enters the parking lot.
*/
class Ticket
{
  int slotNo;
  Car car;

  public Ticket(int slotNo, Car car)
  {
    this.slotNo = slotNo;
    this.car = car;
  }

  //Getter methods
  public int getSlotNo()
  {
    return slotNo;
  }

  public Car getCar()
  {
    return car;
  }
}

/*
** Interface for any Parking Lot that has a ticketing system and implements that whole shebang.
*/
interface TicketGeneration
{
  Ticket generateTicket(Car incomingCar); //generates a ticket once a car enters the parking lot
  int recieveTicket(Ticket ticket); // returns the slotNo of the leaving car so we can mark that slot empty
}
