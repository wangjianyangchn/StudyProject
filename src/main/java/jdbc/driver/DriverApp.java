package jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverApp {

	public static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// https://www.zybuluo.com/pastqing/note/107544

		// import com.mysql.cj.jdbc.Driver;
		// DriverManager.registerDriver(new Driver());

		String url = "jdbc:mysql://localhost:3306/mytest";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		getConnection();
		closeConnection();
	}
}
