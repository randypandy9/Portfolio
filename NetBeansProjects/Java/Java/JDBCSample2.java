// program to show the retrieval of single row
import java.sql.*;

import cmp.DataSource;

public class JDBCSample2 {
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

			// create a string containing some SQL to
			// retrieve three columns with SQL types varchar, integer and decimal
			String SQLStatement = "SELECT name, manager_id, hourly_rate FROM demo.emp WHERE emp_id = 786";
			System.out.println("SQL Statement is: " + SQLStatement);
			
			// execute SQL statement
			rs = stmt.executeQuery(SQLStatement);

			// move to first row of result set
			rs.next();
			
			// extract columns into appropriate java datatypes
			String theName = rs.getString("name");
			int theManagerId = rs.getInt("manager_id");
			double theHourlyRate = rs.getDouble("hourly_rate");
			
			// print them out
			System.out.println("the name is : " + theName);
			System.out.println("the manager id is : " + theManagerId);
			System.out.println("the hourly rate is : " + theHourlyRate);

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