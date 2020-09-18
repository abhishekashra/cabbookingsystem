/**
 * 
 */
package com.abhishek.service.impl;

import java.util.List;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.bean.Driver;
import com.abhishek.controller.BookingController;
import com.abhishek.dao.BookingDao;
import com.abhishek.dao.CustomerDao;
import com.abhishek.dao.DriverDao;
import com.abhishek.exception.CabBookingException;
import com.abhishek.service.BookingService;
import com.abhishek.util.BookingHelper;

/**
 * @author abhishek.ashra
 *
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	private static final Logger logger = Logger.getLogger(BookingController.class);
	@Autowired
	private BookingDao bookingDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	DriverDao driverDao;

	@Autowired
	BookingHelper bookingHelper;

	@Transactional
	public List<Booking> getBookings() throws CabBookingException {
		logger.debug("Inside DriverServiceImpl: getBookings()");
		return bookingDao.getAllBooking();
	}

	@Override
	public synchronized String addBooking(Customer customer) throws CabBookingException {
		StringBuilder bookingStatus = new StringBuilder();
		TreeMap<Double, Integer> treemap = new TreeMap<>();
		List<Driver> driverList = driverDao.getAvailableDriver();
		if (!driverList.isEmpty()) {
			for (Driver driver : driverList) {
				double distance = bookingHelper.distance(customer.getCustomerLatitude(), driver.getCurrentLatitude(),
						customer.getCustomerLongitude(), driver.getCurrentLogitude());
				treemap.put(distance, driver.getDriverId());
			}
			if (treemap.firstEntry().getKey() != -1) {
				customer.setOrderId(customerDao.addCustomer(customer));
				if (customer.getOrderId() != 0) {
					if (driverDao.updateDriver(treemap.firstEntry().getValue(), customer.getOrderId()) != 0) {
						bookingStatus.append("Cab Booked Successfully for Customer " + customer.getCustomerName()
								+ "For Driver " + treemap.firstEntry().getValue());
					} else {
						bookingStatus.append("No Driver Ready to accept the ride");
					}
				} else {
					bookingStatus.append("Booking the cab Failed!!!");
				}
			} else {
				bookingStatus.append("No Avaialable Cabs Nearby, Sorry Do visit Again!!!");
			}
		} else {
			bookingStatus.append("Every Cab Driver is on Leave, Its there Holiday");
		}
		logger.debug(bookingStatus.toString());
		return bookingStatus.toString();

	}

}
