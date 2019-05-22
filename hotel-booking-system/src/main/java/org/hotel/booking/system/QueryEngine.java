package org.hotel.booking.system;

import java.sql.Date;
import java.util.List;

public interface QueryEngine {

	List<Availibility> findHotels(String city, Date startDate, Date endDate, int numberOfGuests, String accomodationType, List<String> facilities);
}
