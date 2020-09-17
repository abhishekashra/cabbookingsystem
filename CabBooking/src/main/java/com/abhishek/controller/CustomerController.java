/**
 * 
 */
package com.abhishek.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.bean.Customer;
import com.abhishek.service.CustomerService;

/**
 * @author Kishori
 *
 */
@RestController
@RequestMapping(value = "/Customer")
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	CustomerService orderService;

	@PostMapping(path = "/AddCustomer")
	public void createOrder(@RequestParam(value = "customerName") String customerName,
			@RequestParam(value = "customerLatitude") double customerLatitude,
			@RequestParam(value = "customerLongitude") double customerLongitude) {
		Customer order = new Customer();
		order.setCustomerName(customerName);
		order.setCustomerLatitude(customerLatitude);
		order.setCustomerLongitude(customerLongitude);
		logger.debug("Inside OrderController : createOrder()" + order.toString());
		orderService.addCustomer(order);
	}

}
