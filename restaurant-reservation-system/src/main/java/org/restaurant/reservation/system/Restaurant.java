package org.restaurant.reservation.system;

import java.time.LocalDateTime;
import java.util.List;

public class Restaurant {

	private int restaurantId;
	private String name;
	private Location location;
	private LocalDateTime openingTime;
	private LocalDateTime closingTime;
	
	private int totalOpenCapacity;
	private int totalClosedCapacity;
	private List<Table> table;
//	public 
	
}
