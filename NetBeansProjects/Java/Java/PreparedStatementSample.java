// prepared statement example
import java.sql.*;

import cmp.*;

public class PreparedStatementSample {
	public static void main(String argv[]) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// load database driver driver
			System.out.println("Database driver is: " + DataSource.getClassName());
			Class.forName(DataSource.getClassName());

			// connect to database from a given URL with a given username and
			// password
			System.out.println("Database URL is: " + DataSource.getURL());
			con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

			// create a string containing some SQL to
			// select all the columns from the employee table for a given
			// employee id
			String strSQL = "SELECT * FROM demo.emp WHERE emp_id = ?";
			
			// create an array of employee ids
			int[] ids = { 815, 848, 856 };
			
			// create an SQL prepared statement object
			ps = con.prepareStatement(strSQL);

			for (int id: ids) {
				// set the value of the emp_id
				ps.setInt(1, id);
				
				// execute SQL statement
				rs = ps.executeQuery();
				
				// move to first row of result set
				rs.next();
				
				// extract name from first row and print
				String theName = rs.getString("name");
				System.out.println("the name is : " + theName);
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
				if (ps != null) {
					ps.close();
					ps = null;
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