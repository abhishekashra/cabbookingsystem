/**
 * 
 */
package com.abhishek.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Driver;
import com.abhishek.controller.BookingController;
import com.abhishek.dao.DriverDao;
import com.abhishek.mapper.DriverMapper;

/**
 * @author Kishori
 *
 */
@Repository
public class DriverDaoImpl implements DriverDao {
	private static final Logger logger = Logger.getLogger(BookingController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Driver> getAvailableDriver() {
		logger.debug("Inside DriverDaoImpl: getAllDrivers()");
		String sql = "select * from Driver where status = 'AVAILABLE';";
		return jdbcTemplate.query(sql, new DriverMapper());
	}

	@Override
	public int updateDriverStatus(int driverId) {
		logger.debug("Inside DriverDaoImpl: updateDriverStatus()");
		SqlParameterSource namedParameter = new MapSqlParameterSource()
				.addValue("driverId", driverId);
		String sql = "UPDATE TABLE DRIVER SET STATUS = 'AVAILABLE' WHERE DRIVERID = :driverId;";
		return jdbcTemplate.update(sql,namedParameter);
	}

}
