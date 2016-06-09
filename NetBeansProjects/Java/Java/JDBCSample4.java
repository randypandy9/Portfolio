// program to show the retrieval of multiple rows
import java.sql.*;

import cmp.DataSource;

public class JDBCSample4 {
	public static void main(String argv[]) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// load database driver driver
			System.out.println("Database driver is: " + DataSource.getClassName());
			Class.forName(DataSource.getClassName());

			// connect to database from a given URL with a given username and password
			System.out.println("Database URL is: " + DataSource.getURL());
			con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

			// create an SQL statement object
			stmt = con.createStatement();

			// create a string containing some SQL to insert a new record
			String SQLStatement = "INSERT INTO xyz VALUES (900,'Other, Ann', 'Programmer', 50, 663)";
			System.out.println("SQL Statement is: " + SQLStatement);

			// execute the insert
			int rowcount = stmt.executeUpdate(SQLStatement);

			// should insert one row
			if (rowcount == 1) {
				System.out.println("insert done OK");
			}
			else {
				System.out.println("insert failed!");
			}
			// create a string containing some SQL to update a table
			SQLStatement = "UPDATE xyz SET hourly_rate = 99";

			// execute the update
			rowcount = stmt.executeUpdate(SQLStatement);

			// could update 0, 1 or many rows
			System.out.println(rowcount + " updates done");
		} catch (SQLException e) {
			// print details of SQL error
			// could be multiple errors chained together
			System.err.println("Error(s) occurred");
			while (e != null) {
				System.err.println("SQLException : " + e.getMessage());
				System.err.println("SQLState : " + e.getSQLState());
				System.err.println("SQLCode : " + e.getErrorCode());
				e = e.getNextException();
				System.err.println();
			}
		} catch (Exception e) {

			// print the error message and the stack trace
			e.printStackTrace(System.err);
		} finally {

			// disconnect and tidy up
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {

				// print the error message and the stack trace
				e.printStackTrace(System.err);
			}
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {

				// print the error message and the stack trace
				e.printStackTrace(System.err);
			}
			try {
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {

				// print the error message and the stack trace
				e.printStackTrace(System.err);
			}
		}
	}
}