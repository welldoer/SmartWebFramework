package net.blogjava.smart4j.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blogjava.smart4j.util.PropsUtil;

public final class DatabaseHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger( DatabaseHelper.class );
	
	private static final QueryRunner QUERY_RUNNER = new QueryRunner();

	private static final String DRIVER;
	private static final String URL;
	
	static {
		Properties conf = PropsUtil.loadProps( "config.properties" );
		
		DRIVER = conf.getProperty( "jdbc.driver" );
		URL = conf.getProperty( "jdbc.url" );
		
		try {
			Class.forName( DRIVER );
		} catch( ClassNotFoundException e ) {
			LOGGER.error( "can not load jdbc driver", e );
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( URL );
		} catch( SQLException e ) {
			LOGGER.error( "get connection failure", e );
		}
		return conn;
	}

	public static void closeConnection( Connection conn ) {
		if( conn != null ) {
			try {
				conn.close();
			} catch( SQLException e ) {
				LOGGER.error( "close connection failure", e );
			}
		}
	}
	
	public static <T> List<T> queryEntityList( Class<T> entityClass, Connection conn, String sql, Object... params ) {
		List<T> entityList;
		try {
			entityList = QUERY_RUNNER.query( conn, sql, new BeanListHandler<T>( entityClass ), params );
		} catch( SQLException e ) {
			LOGGER.error( "query entity list failure", e );
			throw new RuntimeException( e );
		} finally {
			closeConnection( conn );
		}
		return entityList;
	}
	
}
