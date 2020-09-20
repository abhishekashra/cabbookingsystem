/**
 * 
 */
package com.abhishek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Booking;
import com.abhishek.dao.BookingDao;
import com.abhishek.exception.CabBookingException;
import com.abhishek.mapper.BookingMapper;

/**
 * @author abhishek
 *
 */
@Repository
public class BookingDaoImpl implements BookingDao {
	
	private static final Logger logger = Logger.getLogger(BookingDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Booking> getAllBooking() throws CabBookingException{
		List<Booking> bookingList = new ArrayList<>();
		logger.debug("Inside BookingDaoImpl: getAllBooking()");
		String sql = "select d.driverName AS DRIVERNAME, Coalesce(o.customerName,'-') AS CUSTOMERNAME, d.status AS STATUS from Drivers d LEFT JOIN Orders o ON d.orderId = o.orderId ORDER BY DRIVERNAME;";
		try {
			bookingList = jdbcTemplate.query(sql, new BookingMapper());
			logger.debug("Booking List: "+bookingList.toString());
		} catch (Exception e) {
			logger.error("Issue occured while fetching the Booking List from database");
		}
		return bookingList;
	}
}
