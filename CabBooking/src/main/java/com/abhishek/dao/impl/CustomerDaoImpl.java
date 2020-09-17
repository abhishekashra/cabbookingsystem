/**
 * 
 */
package com.abhishek.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Customer;
import com.abhishek.dao.CustomerDao;
import com.abhishek.exception.CabBookingException;

/**
 * @author Kishori
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
 
	@Override
	public int addCustomer(Customer customer) {
		logger.debug("Inside CustomerDaoImpl: addCustomer()");
		int customerStatus = 0;
		Map<String,Object> namedParameter = new HashMap<>();
		namedParameter.put("customerName",customer.getCustomerName());
		namedParameter.put("customerLatitude", customer.getCustomerLatitude());
		namedParameter.put("customerLongitude", customer.getCustomerLongitude());
		String sql = "insert into Customer(customerName,customerLatitude, customerLongitude) values (:customerName,:customerLatitude,:customerLongitude)";
		try {
			customerStatus = jdbcTemplate.update(sql,namedParameter);	
		}catch (Exception e) {
			customerStatus = 0;
			//throw new CabBookingException("Issue occured while booking the cab");
		}
		return customerStatus;
	}

}
