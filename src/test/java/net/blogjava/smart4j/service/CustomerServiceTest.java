package net.blogjava.smart4j.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import net.blogjava.smart4j.model.Customer;

class CustomerServiceTest {
	
	private CustomerService customerService;

	@BeforeEach
	void setUp() throws Exception {
		customerService = new CustomerService();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testGetCustomerList() {
		List<Customer> customerList = customerService.getCustomerList( "" );
		Assertions.assertEquals( 2, customerList.size() );
	}
	
//	@Disabled
//	@Test
//	public void testGetCustomer() {
//		Customer customer = customerService.getCustomer( 1 );
//		Assertions.assertNotNull( customer );
//	}
//	
//	@Disabled
//	@Test
//	public void testCreateCustomer() {
//		Map<String, Object> fieldMap = new HashMap<>();
//		fieldMap.put( "name", "customer100" );
//		fieldMap.put( "contact", "John" );
//		fieldMap.put( "telephone", "13512345678" );
//		boolean result = customerService.createCustomer( fieldMap );
//		Assertions.assertTrue( result );
//	}
//
//	@Disabled
//	@Test
//	public void testUpdateCustomer() {
//		Map<String, Object> fieldMap = new HashMap<>();
//		fieldMap.put( "contact", "Eric" );
//		boolean result = customerService.updateCustomer( 1, fieldMap );
//		Assertions.assertTrue( result );
//	}
//	
//	@Disabled
//	@Test
//	public void testDeleteCustomer() {
//		boolean result = customerService.deleteCustomer( 1 );
//		Assertions.assertTrue( result );
//	}
}
