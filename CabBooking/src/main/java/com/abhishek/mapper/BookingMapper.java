/**
 * 
 */
package com.abhishek.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhishek.bean.Booking;
import com.abhishek.bean.Customer;
import com.abhishek.bean.Driver;

/**
 * @author Kishori
 *
 */
public class BookingMapper implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking booking = new Booking();
		Driver driver = new Driver();
		Customer customer = new Customer();
		driver.setDriverName(rs.getString("DRIVERNAME"));
		driver.setStatus(rs.getString("STATUS"));
		booking.setDriver(driver);
		customer.setCustomerName(rs.getString("CUSTOMERID"));
		booking.setCustomer(customer);
		return booking;
	}

}
