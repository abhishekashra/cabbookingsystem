/**
 * 
 */
package com.abhishek.dao;

import java.util.List;

import com.abhishek.bean.Booking;
import com.abhishek.exception.CabBookingException;

/**
 * @author abhishek
 *
 */
public interface BookingDao {
	
	/**
	 * This method is used to get all the Bookings to view on screen
	 * @return {@link List} of {@link Booking}
	 */
	public List<Booking> getAllBooking() throws CabBookingException;

}
