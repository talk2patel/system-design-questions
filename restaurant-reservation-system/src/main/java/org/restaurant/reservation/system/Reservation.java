package org.restaurant.reservation.system;

import java.time.LocalDateTime;

public class Reservation {

	private int restaurantId;
	private int customeId;
	private LocalDateTime startTime;
	private LocalDateTime endtime;
	private int partySize;
	private ReservationStatus status;
}
