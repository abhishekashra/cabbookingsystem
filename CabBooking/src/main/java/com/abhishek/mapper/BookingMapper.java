/**
 * 
 */
package com.abhishek.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhishek.bean.Booking;

/**
 * @author abhishek
 *
 */
public class BookingMapper implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking booking = new Booking();
		booking.setDriverName(rs.getString("DRIVERNAME"));
		booking.setCustomerName(rs.getString("CUSTOMERNAME"));
		booking.setDriverStatus(rs.getString("STATUS"));
		return booking;
	}

}
