package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionsApp {

	public void operate() {
		Connection connection = DriverApp.getConnection();

		try {
			connection.setAutoCommit(false);
			// create and execute statements etc.
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DriverApp.closeConnection();
		}

	}
}
