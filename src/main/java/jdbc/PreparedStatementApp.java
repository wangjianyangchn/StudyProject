package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementApp {

	public void operate() {
		Connection connection = DriverApp.getConnection();

		try {
			String sql = "update people set firstname=? , lastname=? where id=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, "Gary");
			preparedStatement.setString(2, "Larson");
			preparedStatement.setLong(3, 123);

			// 1.PreparedStatement Performance
			// http://tutorials.jenkov.com/jdbc/preparedstatement.html

			// 2.SQL Injection
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
