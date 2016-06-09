// program to show the retrieval of multiple rows
import java.sql.*;

import cmp.DataSource;

public class JDBCSample3 {
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
			// retrieve two columns with SQL types integer and varchar
			String SQLStatement = "SELECT emp_id, name FROM demo.emp ORDER BY emp_id";
			System.out.println("SQL Statement is: " + SQLStatement);
			
			// execute SQL statement
			rs = stmt.executeQuery(SQLStatement);

			// loop to step through each row of result set
			while (rs.next()) {
				int theEmpId = rs.getInt("emp_id");
				String theName = rs.getString("name");
				System.out.println(theEmpId + " : " + theName);
			}

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