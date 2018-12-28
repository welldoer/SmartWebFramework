package net.blogjava.smart4j.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blogjava.smart4j.helper.DatabaseHelper;
import net.blogjava.smart4j.model.Customer;

public class CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger( CustomerService.class );
	
	public List<Customer> getCustomerList( String keyword ) {
		try {
			String sql = "SELECT * FROM customer";
			return DatabaseHelper.queryEntityList( Customer.class, sql );
		} finally {
			DatabaseHelper.closeConnection();
		}
	}
	
	public Customer getCustomer( long id ) {
		return null;
	}
	
	public boolean createCustomer( Map<String, Object> fieldMap ) {
		return false;
	}
	
	public boolean updateCustomer( long id, Map<String, Object> fieldMap ) {
		return false;
	}
	
	public boolean deleteCustomer( long id ) {
		return false;
	}
}
