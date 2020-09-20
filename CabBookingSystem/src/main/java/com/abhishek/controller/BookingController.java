package com.abhishek.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.exception.CabBookingException;
import com.abhishek.service.BookingService;

/**
 * @author abhishek
 *
 */
@RestController
@RequestMapping(value = "/Booking")
public class BookingController {
	private static final Logger logger = Logger.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;

	/**
	 * Rest end point to get all the Bookings from the database
	 * @return {@link List} of {@link Booking}
	 * @throws CabBookingException 
	 */
	@GetMapping(value = "/GetBookings")
	public List<Booking> getBookings() throws CabBookingException{
		logger.debug("Inside BookingController: getBookings()");
		return bookingService.getBookings();
	}
	
	/**
	 * Rest end point to add the booking in the database
	 * @param customer
	 * @return Message to show the user
	 * @throws CabBookingException
	 */
	@PostMapping(value = "/CreateBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addBooking(@RequestBody Customer customer) throws CabBookingException {
		logger.debug("Inside BookingController: addBooking()"+customer.toString());
		return bookingService.addBooking(customer);
	}
}
