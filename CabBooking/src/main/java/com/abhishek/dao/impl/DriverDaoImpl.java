/**
 * 
 */
package com.abhishek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Driver;
import com.abhishek.controller.BookingController;
import com.abhishek.dao.DriverDao;
import com.abhishek.exception.CabBookingException;
import com.abhishek.mapper.DriverMapper;

/**
 * @author abhishek
 *
 */
@Repository
public class DriverDaoImpl implements DriverDao {
	private static final Logger logger = Logger.getLogger(BookingController.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Driver> getAvailableDriver() throws CabBookingException {
		List<Driver> driverList = new ArrayList<>();
		logger.debug("Inside DriverDaoImpl: getAllDrivers()");
		String sql = "select * from Drivers where status = 'AVAILABLE';";
		try {
			driverList = namedParameterJdbcTemplate.query(sql, new DriverMapper());
		} catch (Exception e) {
			logger.error("Issue occured while geting all the AVAILABLE Drivers-"+e.getMessage());
			throw new CabBookingException("Issue occured while geting all the AVAILABLE Drivers");

		}
		return driverList;
	}

	@Override
	public int updateDriver(int driverId, int orderId) {
		logger.debug("Inside DriverDaoImpl: updateDriverStatus()");
		int updateStatus = 0;
		SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("orderId", orderId)
				.addValue("driverId", driverId);
		String sql = "update Drivers SET status = 'BUSY', orderId = :orderId  WHERE driverId= :driverId;";
		try {
			updateStatus = namedParameterJdbcTemplate.update(sql, namedParameter);
		} catch (Exception e) {
			updateStatus = 0;
		}
		return updateStatus;
	}

}
