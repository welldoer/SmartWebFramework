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
		Connection conn = null;
		try {
			List<Customer> customerList = new ArrayList<>();
			String sql = "SELECT * FROM customer";
			conn = DatabaseHelper.getConnection();
			PreparedStatement stmt = conn.prepareStatement( sql );
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				Customer customer = new Customer();
				customer.setId( rs.getLong( "id" ) );
				customer.setName( rs.getString( "name" ) );
				customer.setContact( rs.getString( "contact" ) );
				customer.setTelephone( rs.getString( "telephone" ) );
				customer.setEmail( rs.getString( "email" ) );
				customer.setRemark( rs.getString( "remark" ) );
				customerList.add( customer );
			}
			return customerList;
		} catch( SQLException e ) {
			LOGGER.error( "execute sql failure", e );
		} finally {
			DatabaseHelper.closeConnection( conn );
		}
		return null;
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
