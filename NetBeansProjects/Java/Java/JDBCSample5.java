import java.sql.*;
import cmp.*;

public class JDBCSample5 {

	// shared by all methods
	static Connection con;
	static Statement stmt;

	public static void main(String argv[]) {
		try {
			// connect to the database
			connect();
			
			// get all of the employees records
			ResultSet rs = getAllEmp();

			System.out.println("| Name | ManagerId | Hourly rate |"); 
			while (rs.next()) {
				// extract columns into appropriate java datatypes
				String theName = rs.getString("name");
				int theManagerId = rs.getInt("manager_id");
				double theHourlyRate = rs.getDouble("hourly_rate");

				// print them out
				//System.out.println("the name is : " + theName);
				//System.out.println("the manager id is : " + theManagerId);
				//System.out.println("the hourly rate is : " + theHourlyRate);
				
				System.out.println(theName + theManagerId + theHourlyRate);

			}
			rs.close();
			
			// update a record
			int nCount = updateHourlyRate(856, 99.99);
			System.out.println(nCount + " records updated");
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
			try {
				disconnect();
			} catch (Exception e) {
				// print the error message and the stack trace
				e.printStackTrace(System.err);
			}
		}
	}

	// load driver and connect to database
	static void connect() throws SQLException, ClassNotFoundException, DataSourceException {
		try {
			// load database driver driver
			System.out.println("Database driver is: " + DataSource.getClassName());
			Class.forName(DataSource.getClassName());

			// connect to database from a given URL with a given username and
			// password
			System.out.println("Database URL is: " + DataSource.getURL());
			Connection con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

			// create an SQL statement object
			stmt = con.createStatement();
		} catch (SQLException se) {
			con = null;
			stmt = null;
			throw (se);
		}
	}

	// a sample update method
	static int updateHourlyRate(int nID, double dNewRate) throws SQLException {

		// create a string containing some SQL to update a table
		String strSQL = "UPDATE xyz SET hourly_rate = " + dNewRate + " WHERE emp_id = " + nID;

		// execute the update
		int nRowCount = stmt.executeUpdate(strSQL);
		return nRowCount;
	}

	// a sample retrieval method
	static ResultSet getAllEmp() throws SQLException {

		// create a string containing some SQL to retrieve all columns from a
		// table
		String strSQL = "SELECT * FROM demo.emp";
		ResultSet rs = stmt.executeQuery(strSQL);
		return rs;
	}

	// used to disconnect from database
	static void disconnect() throws SQLException {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} finally {
			stmt = null;
		}
		try {
			if (con != null) {
				con.close();
			}
		} finally {
			con = null;
		}
	}
}
