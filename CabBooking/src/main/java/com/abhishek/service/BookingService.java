/**
 * 
 */
package com.abhishek.service;

import java.util.List;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.exception.CabBookingException;

/**
 * @author abhishek
 *
 */
public interface BookingService {

	/**
	 * This method is used to get the Bookings to view on UI
	 * 
	 * @return {@link List} of {@link Booking}
	 * @throws CabBookingException
	 */
	public List<Booking> getBookings() throws CabBookingException;

	/**
	 * This method is used to add the Booking in the database for most closest
	 * driver for the customer
	 * 
	 * @param customer
	 * @return Message as per the outcome of booking
	 * @throws CabBookingException
	 */
	public String addBooking(Customer customer) throws CabBookingException;
}
