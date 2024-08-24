package app.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



public class JdbcUtil {
	private static Connection connection = null;
	private static DataSource dataSource=null;

	private JdbcUtil() {

	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		HikariConfig config = new HikariConfig("src/app/properties/db.properties");
		dataSource = new HikariDataSource(config);
		connection = dataSource.getConnection();
		return connection;
	}

	/*
	 * public static Connection getJdbcConnection() throws SQLException, IOException
	 * { FileInputStream fis = new FileInputStream(
	 * "D:\\JavaProjects\\JDBCCRUDApp\\src\\app\\properties\\db.properties");
	 * Properties properties = new Properties(); properties.load(fis); String url =
	 * properties.getProperty("url"); String userName =
	 * properties.getProperty("user"); String password =
	 * properties.getProperty("password");
	 * 
	 * connection = DriverManager.getConnection(url, userName, password); return
	 * connection; }
	 */
}
