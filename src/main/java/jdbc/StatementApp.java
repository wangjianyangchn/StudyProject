package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementApp {

	@SuppressWarnings("unused")
	public void operate() throws SQLException {
		Connection connection = DriverApp.getConnection();

		Statement statement = connection.createStatement();
		// 1.insert
		boolean insertFlag = statement
				.execute("insert into user values (1,'user1')");
		// 2.delete
		boolean delFlag = statement.execute("delete * from user where id = 1");
		// 3.update
		int rowsAffected = statement
				.executeUpdate("update user set name='updateName' where id = 1");
		// 4.queue
		ResultSet resultSet = statement.executeQuery("select * from user");

		statement.addBatch("update people set firstname='John' where id=123");
		statement.addBatch("update people set firstname='Eric' where id=456");
		statement.addBatch("update people set firstname='May'  where id=789");
		// 5.batch insert delete update
		int[] recordsAffected = statement.executeBatch();
		// The int[] array returned by the executeBatch() method is an array of
		// int telling how many records were affected by each executed SQL
		// statement in the batch.

		// Batch Updates and Transactions
		statement.close();
		DriverApp.closeConnection();
	}

	public static void main(String[] args) {

	}

}
