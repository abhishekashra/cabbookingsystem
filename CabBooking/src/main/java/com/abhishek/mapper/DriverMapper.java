package com.abhishek.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhishek.bean.Driver;

public class DriverMapper implements RowMapper<Driver> {

	@Override
	public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
		Driver driver = new Driver();
		driver.setDriverId(rs.getInt("driverId"));
		driver.setDriverName(rs.getString("driverName"));
		driver.setCurrentLatitude(rs.getInt("currentLatitude"));
		driver.setCurrentLogitude(rs.getInt("currentLogitude"));
		driver.setStatus(rs.getString("status"));
		
		return driver;
		
	}

}
