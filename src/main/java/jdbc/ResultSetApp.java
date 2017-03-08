package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetApp {

	public void operate() {
		Connection connection = DriverApp.getConnection();

		String sql = "select * from people set where id=? and firstname=?";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setLong(1, 123);
			preparedStatement.setString(2, "Larson");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				resultSet.getString("firstname");
				resultSet.getLong(1); // == resultSet.getLong("id");

			}
			// http://tutorials.jenkov.com/jdbc/resultset.html

			// 1.ResultSet Types
			// ResultSet.TYPE_FORWARD_ONLY;//default 1->2->3
			// ResultSet.TYPE_SCROLL_INSENSITIVE;
			// ResultSet.TYPE_SCROLL_SENSITIVE;

			// 2.Navigation Methods

			// 3.ResultSet Concurrency
			// ResultSet.CONCUR_READ_ONLY //ResultSet can only be read
			// ResultSet.CONCUR_UPDATABLE //can be both read and updated.

			// 4.Updating or Inserting Rows into a ResultSet

			// 5.ResultSet Holdability

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DriverApp.getConnection();
	}
}
