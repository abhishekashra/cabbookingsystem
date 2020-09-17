/**
 * 
 */
package com.abhishek.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Booking;
import com.abhishek.controller.BookingController;
import com.abhishek.dao.BookingDao;
import com.abhishek.exception.CabBookingException;
import com.abhishek.mapper.BookingMapper;

/**
 * @author abhishek.ashara
 *
 */
@Repository
public class BookingDaoImpl implements BookingDao {
	
	private static final Logger logger = Logger.getLogger(BookingDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Booking> getAllBooking() {
		logger.debug("Inside BookingDaoImpl: getAllBooking()");
		String sql = "select b.bookingId as BOOKINGID, d.driverName AS DRIVERNAME,cu.customerName AS CUSTOMERNAME,d.status AS STATUS from Booking b INNER JOIN Driver d ON b.driverId = d.driverId INNER JOIN Customer cu ON b.customerId = cu.customerId";
		//select b.bookingId as BOOKINGID, d.driverId AS DRIVERID,cu.customerId AS CUSTOMERID from Booking b INNER JOIN Driver d ON b.driverId = d.driverId INNER JOIN Customer cu ON b.customerId = cu.customerId
		return jdbcTemplate.query(sql, new BookingMapper());
	}

	@Override
	public int addBooking(Booking booking) throws CabBookingException{
		logger.debug("Inside BookingDaoImpl: addBooking()");
		int bookinStatus = 0;
		Map<String,Object> namedParameter = new HashMap<>();
		namedParameter.put("driverId",booking.getDriver().getDriverId());
		namedParameter.put("customerId", booking.getCustomer().getCustomerId());
		String sql = "insert into Booking(driverId,customerId) values (:driverId,:customerId)";
		try {
			bookinStatus = jdbcTemplate.update(sql,namedParameter);	
		}catch (Exception e) {
			bookinStatus = 0;
			throw new CabBookingException("Issue occured while booking the cab");
		}
		return bookinStatus;
	}

}
