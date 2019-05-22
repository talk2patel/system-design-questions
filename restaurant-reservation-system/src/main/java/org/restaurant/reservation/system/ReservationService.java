package org.restaurant.reservation.system;

import java.time.LocalDateTime;
import java.util.List;

//Useful for online restaurant booking
public interface ReservationService {

	List<Availability> getAvailability(Location location, LocalDateTime startTime, LocalDateTime endTime, int partySize);
	
	//Can throw exception because availability information was stale
	Reservation makeReservation(Restaurant res, Location location, LocalDateTime startTime, LocalDateTime endTime, int partySize, Customer customer) throws BookingFailureException;
	void cancelReservation(Reservation reservation);
}
