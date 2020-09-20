/**
 * 
 */
package com.abhishek.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abhishek.bean.Customer;
import com.abhishek.dao.CustomerDao;

/**
 * @author abhishek
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);
		
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	
 
	@Override
	public int addCustomer(Customer customer) {
		logger.debug("Inside CustomerDaoImpl: addCustomer()");
		int customerId = 0;
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource namedParameter = new MapSqlParameterSource()
				.addValue("customerName",customer.getCustomerName())
				.addValue("customerLatitude", customer.getCustomerLatitude())
				.addValue("customerLongitude", customer.getCustomerLongitude());
		String sql = "insert into Orders(customerName, customerLatitude, customerLongitude) values (:customerName,:customerLatitude,:customerLongitude);";
		try {
			namedParameterJdbcTemplate.update(sql, namedParameter, holder);
			customerId = (int) holder.getKeys().get("OrderId");
			
		}catch (Exception e) {
			customerId = 0;
		}
		return customerId;
	}

}
