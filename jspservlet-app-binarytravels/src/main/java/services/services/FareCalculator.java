package services;



public class FareCalculator extends Booking {

	public double book(Hotel hotel) {
	    //Check-In date should be less than Check-Out date
	    if (hotel.getFromdate().isAfter(hotel.getTodate())) {
	        throw new IllegalArgumentException("Check-In date should be less than Check-Out date");
	    }

	    //Single occupancy can be given only for 1 guest
	    if (hotel.getNoOfPersons() > 1 && hotel.getRoomType().equals("single")) {
	        throw new IllegalArgumentException("Single occupancy can be given only for 1 guest");
	    }

	    //Calculate the total fare
	    return hotel.getRates() * hotel.getNoOfPersons();
	}

  public double book(Flight flight) {

    double totalFare = 0;

    // If one way trip is selected then departure date is not considered for fare calculation
    if (flight.getTriptype().equals("one-way")) {
      totalFare = flight.getRates();
    } else {
      // For round trips Start date should be less than return date
      if (flight.getFrom().isAfter(flight.getTo())) {
        System.out.println("For round trips Start date should be less than return date.");
        return 0;
      }
      totalFare =flight.getRates() * 2;
    }

    return totalFare;
  }
  public double book(Train train) {
      return train.getNoOfPersons()*train.getRates();
  }

  public double book(Bus bus) {
      return bus.getNoOfPersons()*bus.getRates();
  }
}