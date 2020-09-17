/**
 * 
 */
package com.abhishek.service;

import java.util.List;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.exception.CabBookingException;

/**
 * @author Kishori
 *
 */
public interface BookingService {

	public List<Booking> getBookings();

	public String addBooking(Customer customer) throws CabBookingException;
}
