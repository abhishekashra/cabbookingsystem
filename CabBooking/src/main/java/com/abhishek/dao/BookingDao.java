/**
 * 
 */
package com.abhishek.dao;

import java.util.List;

import com.abhishek.bean.Booking;
import com.abhishek.exception.CabBookingException;

/**
 * @author Kishori
 *
 */
public interface BookingDao {
	
	public List<Booking> getAllBooking();

	public int addBooking(Booking booking) throws CabBookingException;
	

}
