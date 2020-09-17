package com.abhishek.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.exception.CabBookingException;
import com.abhishek.service.BookingService;

/**
 * @author abhishek.ashara
 *
 */
@RestController
@RequestMapping(value = "/Booking")
public class BookingController {
	private static final Logger logger = Logger.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;

	/**
	 * @return
	 */
	@GetMapping(value = "/GetBookings")
	public List<Booking> getBookings(){
		logger.debug("Inside BookingController: getBookings()");
		return bookingService.getBookings();
	}
	
	@PostMapping(value = "/CreateBooking")
	public String addBooking(
			@RequestParam(value="customerName") String customerName
			,@RequestParam(value="customerLatitude") String customerLatitude
			,@RequestParam(value="customerLongitude") String customerLongitude) throws CabBookingException {
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerLatitude(Double.parseDouble(customerLatitude));
		customer.setCustomerLongitude(Double.parseDouble(customerLongitude));
		return bookingService.addBooking(customer);
	}
}
