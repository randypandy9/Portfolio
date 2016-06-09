// defining a database class
import cmp.DataSourceException;
import java.sql.*;
import cmp.DataSource;

public class Database5
{
   static Connection con;  // shared by all the methods
   static Statement stmt;

	// load driver and connect to database
	static void connect() throws SQLException, ClassNotFoundException, DataSourceException
	{
		try 
		{
			Class.forName(DataSource.getClassName());
			Connection con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());
			stmt = con.createStatement();
		}
		catch( SQLException se )
		{
			con = null;
			throw (se);
		}
	}

	// a sample update method
	static int updateHourlyRate(int nID, double dNewRate) throws SQLException
	{
		int nRowCount = 0;
		try 
		{
			String strSQL = "UPDATE xyz SET hourly_rate = " + dNewRate + " WHERE emp_id = " + nID;
			nRowCount = stmt.executeUpdate(strSQL);
		}
		catch(SQLException se)
		{
			nRowCount = -1;
			throw (se);
		}
		return nRowCount;
	}

	// a sample retrieval method
	static ResultSet getAllEmp() throws SQLException
	{
		ResultSet rs = null;
		try 
		{
           String strSQL = "SELECT * FROM demo.emp";
           rs = stmt.executeQuery(strSQL);
		}
		catch(SQLException se)
		{
			rs = null;
			throw (se);
		}
		return rs;
	}

	// used to disconnect from database
	static void disconnect() throws SQLException
	{
		try 
		{
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} 
		catch( SQLException se ) 
		{
			throw (se);
		}
		finally
		{
			stmt = null;
			con = null;	
		}
	}
}
