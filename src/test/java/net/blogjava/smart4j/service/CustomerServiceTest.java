package net.blogjava.smart4j.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.blogjava.smart4j.helper.DatabaseHelper;
import net.blogjava.smart4j.model.Customer;

public class CustomerServiceTest {
	
	private CustomerService customerService;

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerService();
		
		DatabaseHelper.executeSqlFile( "sql/customer_init.sql" );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCustomerList() {
		List<Customer> customerList = customerService.getCustomerList( "" );
		assertNotEquals( 1, customerList.size() );
	}
	
	@Test
	public void testGetCustomer() {
		Customer customer = customerService.getCustomer( 1 );
		assertNotNull( customer );
	}
	
	@Test
	public void testCreateCustomer() {
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put( "name", "customer100" );
		fieldMap.put( "contact", "John" );
		fieldMap.put( "telephone", "13512345678" );
		boolean result = customerService.createCustomer( fieldMap );
		assertTrue( result );
	}

	@Test
	public void testUpdateCustomer() {
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put( "contact", "Eric" );
		boolean result = customerService.updateCustomer( 1, fieldMap );
		assertTrue( result );
	}
	
	@Test
	public void testDeleteCustomer() {
		boolean result = customerService.deleteCustomer( 2 );
		assertTrue( result );
	}
}
