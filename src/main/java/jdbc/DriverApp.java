package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverApp {

	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// https://www.zybuluo.com/pastqing/note/107544
		//http://blog.csdn.net/wangligong/article/details/52828083?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
		
		// import com.mysql.cj.jdbc.Driver;
		// DriverManager.registerDriver(new Driver());

		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = "root";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
