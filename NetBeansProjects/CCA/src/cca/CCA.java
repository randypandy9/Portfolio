package cca;

import cmp.DataSource;
import cmp.DataSourceException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class CCA {

    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nNOTE: type 0/exit to exit in types int/string inputs respectively\n");
        System.out.println("===== CHEAP AND CHEERFUL AIRWAYS =====\n");
        System.out.println("1 - Create New Customer");
        System.out.println("2 - Create New Flight");
        System.out.println("3 - Delete Customer");
        System.out.println("4 - Delete Flight");
        System.out.println("5 - See Available Seats On All Flights");
        System.out.println("6 - Check Status Of Seats On Flight");
        System.out.println("7 - Create Flight Booking");
        System.out.println("8 - Cancel Booking");
        System.out.println("9 - Get Emails Due to Flight Rescheduling");
        System.out.println("10 - Release Old Seats (24 hours+)");
        System.out.println("11 - Check Flight On Specific Date");
        System.out.println("12 - Edit Booking (Seats)");
        System.out.println("13 - Edit Booking (Paid)");

        System.out.println("\nEnter integer to run:");
        int chooser = scan.nextInt();
        exiter(chooser);
        switch (chooser) {
            case 1:
                one(); main(args);
            case 2:
                two(); main(args);
            case 3:
                three(); main(args);
            case 4:
                four(); main(args);
            case 5:
                five(); main(args);
            case 6:
                six(); main(args);
            case 7:
                seven(); main(args);
            case 8:
                eight(); main(args);
            case 9:
                nine(); main(args);
            case 10:
                ten(); main(args);
            case 11:
                eleven(); main(args);
            case 12:
                changeSeats(); main(args);
            case 13:
                hasNowPaid(); main(args);
            default:
                System.out.println("Entered value unknown...");
                cont();
                main(args);
        }
    }

    public static void one()//works
    {
        Scanner scan = new Scanner(System.in);
        int id;
        String fname, sname, address, email;
        System.out.println("ENTER ID:");
        id = scan.nextInt();
        System.out.println("ENTER FIRST NAME:");
        fname = scan.next();
        System.out.println("ENTER SURNAME:");
        sname = scan.next();
        System.out.println("ENTER ADDRESS:");
        scan.nextLine();
        address = scan.nextLine();
        System.out.println("ENTER EMAIL:");
        email = scan.next();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Statement checkcust = null;
        ResultSet checkcustrs = null;

        try {

            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            checkcust = con.createStatement();

            String checkCustStr = "SELECT * FROM emails;";
            checkcustrs = checkcust.executeQuery(checkCustStr);
            boolean custExists = false;
            while (checkcustrs.next()) {
                String chkEmail = checkcustrs.getString("email");
                if (chkEmail.matches(email)) {
                    custExists = true;
                }
            }

            if (custExists) {
                System.out.println("\nCustomer Already Exists!");

            } else {
                // load database driver driver
                System.out.println("Database driver is: " + DataSource.getClassName());
                Class.forName(DataSource.getClassName());

                // connect to database from a given URL with a given username and password
                System.out.println("Database URL is: " + DataSource.getURL());
                con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

                // create an SQL statement object
                stmt = con.createStatement();

                // create a string containing some SQL to insert a new record
                String SQLStatement = "INSERT INTO LeadCustomer VALUES (" + id + ",'" + fname + "', '" + sname + "', '" + address + "','" + email + "');";
                System.out.println("SQL Statement is: " + SQLStatement);

                // execute the insert
                int rowcount = stmt.executeUpdate(SQLStatement);

                // should insert one row
                if (rowcount == 1) {
                    System.out.println("insert done OK");
                } else {
                    System.out.println("insert failed!");
                }
            }
            cont();
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

    public static void two() throws ParseException//works
    {
        Scanner scan = new Scanner(System.in);
        int flightid, capacity, pps;
        String origin,destination, strdate;


        System.out.println("ENTER ID:");
        flightid = scan.nextInt();
        System.out.println("ENTER ORIGIN:");
        origin = scan.next();
        System.out.println("ENTER DESTINATION:");
        destination = scan.next();
        System.out.println("ENTER PRICE PER SEAT:");
        pps = scan.nextInt();
        //--------------
        System.out.println("ENTER DATE AND TIME: (yyyy-mm-dd hh:mm:ss)");
        scan.nextLine();
        strdate = scan.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //--------------
        System.out.println("ENTER CAPACITY");
        capacity = scan.nextInt();


        Connection con = null;
        Statement stmt = null,stmt2 = null;
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
            stmt2 = con.createStatement();

            // create a string containing some SQL to insert a new record
            String SQLStatement = "INSERT INTO flight VALUES ("+flightid+",'"+strdate+"', '"+origin+"', '"+destination+"','"+capacity+"',"+pps+");";
            System.out.println(SQLStatement);
            String emptyBooking = "INSERT INTO flightbooking VALUES ("+(-flightid)+",0,"+flightid+",0,'r','0001-01-01 00:00:00',0);";

            // execute the insert
            int madeflight = stmt.executeUpdate(SQLStatement);
            //int madeemptybooking = stmt2.executeUpdate(SQLStatement);

            // should insert one row
            if (madeflight == 1) {
                System.out.println("insert done OK");
            } else {
                System.out.println("insert failed!");
                //shows which part failed
            }
            cont();
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

    public static void three()//works
    {
        Scanner scan = new Scanner(System.in);
        int customerid;
        System.out.println("ENTER CUSTOMER ID:");
        customerid = scan.nextInt();


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
            //deletes all traces too
            String SQLStatement = "DELETE FROM LeadCustomer WHERE CustomerID="+customerid+";";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute the insert
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 1) {
                System.out.println("deletion done OK");
            } else {
                System.out.println("deletion failed!");
            }
            cont();
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

    public static void four()//works
    {
        Scanner scan = new Scanner(System.in);
        int flightid;
        System.out.println("ENTER FLIGHT ID:");
        flightid = scan.nextInt();


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
            String SQLStatement = "DELETE FROM Flight WHERE FlightID="+flightid+";";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute the insert
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 1) {
                System.out.println("deletion done OK");
            } else {
                System.out.println("deletion failed!");
            }
            cont();
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

    public static void five()//works
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load database driver driver
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            // create a string containing some SQL to
            // select just a name from the employee table
            String SQLStatement = "SELECT DISTINCT Flight.FlightID,FlightDate,Origin,Destination,MaxCapacity,\n" +
            "COALESCE(MaxCapacity-(SELECT SUM(NumSeats) FROM FlightBooking \n" +
            "WHERE Flight.FlightID = Flightbooking.FlightID AND (Status = 'R' OR Status = 'H')),MaxCapacity) AS SeatsRemaining\n" +
            "FROM Flight LEFT JOIN FlightBooking\n" +
            "ON Flight.FlightID = FlightBooking.FlightID\n" +
            "ORDER BY FlightID;";

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                    int flightid = rs.getInt("flightid");
                    java.sql.Timestamp dtt = rs.getTimestamp("flightdate");
                    String origin = rs.getString("origin");
                    String destination = rs.getString("destination");
                    int maxcapacity = rs.getInt("maxcapacity");
                    int seatsleft = rs.getInt("seatsremaining");
                    System.out.println("Flight ID:" + flightid + " | Flight Date: "
                            + dtt.toString()+" | Origin:"+origin +" | Destination:"
                            + destination + " | Max Capacity:" + maxcapacity +
                            " | Seats Remaining:" + seatsleft);
            }
        cont();
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

    public static void six()//works //make nicer output?
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER FLIGHT ID:");
        int flightid = scan.nextInt();

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
            // select just a name from the employee table
            String SQLStatement = "SELECT Status FROM FlightBooking WHERE flightID="+flightid+";";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            while (rs.next()) {
                    String status = rs.getString("Status");
                    System.out.println("Status of seat: " + status);
            }
            cont();
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

    public static void seven()//works
    {
        Scanner scan = new Scanner(System.in);

        int bookingid, customerid, flightid, seats;
        String status = "H", paid;

        System.out.println("ENTER BOOKING ID:"); //autogenerate?
        bookingid = scan.nextInt();
        exiter(bookingid);
        System.out.println("ENTER CUSTOMER ID:");
        customerid = scan.nextInt();
        exiter(customerid);
        System.out.println("ENTER FLIGHT ID:");
        flightid = scan.nextInt();
        exiter(flightid);
        System.out.println("ENTER SEATS");
        seats = scan.nextInt();
        exiter(seats);
        System.out.println("PAYMENT RECIEVED? y/n");
        paid = scan.next();
        if (paid.equals("y")) {
            status = "R";
        } else {
            System.out.println("unknown value entered, please rebook...");
            seven();//main?
        }
        java.util.Date date = new java.util.Date();
        Timestamp booktime = new Timestamp(date.getTime());
        booktime.setNanos(0);
        Connection con = null;
        Statement stmt = null, stmt2 = null, stmt3 = null;
        ResultSet rs = null, rs2 = null;
        try {
            // load database driver driver
            System.out.println("Database driver is: " + DataSource.getClassName());
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            System.out.println("Database URL is: " + DataSource.getURL());
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();
            stmt2 = con.createStatement();

            String checkFlight = "SELECT customerID FROM leadcustomer WHERE customerID="+customerid+";";


            String getflightcost = "SELECT priceperseat FROM Flight WHERE flightid="+flightid+";";


            // execute SQL statement
            rs = stmt.executeQuery(getflightcost);

            // move to first row of result set
            int pps=0;
            while(rs.next())
            {
                pps = rs.getInt("priceperseat");
            }
            int seatsLeftOnFlight = getSeatsLeft(flightid);

            if (seatsLeftOnFlight >= seats) {
                // create a string containing some SQL to insert a new record
                String aa = "INSERT INTO FlightBooking VALUES (" + bookingid + ",'" + customerid + "', '" + flightid + "', '" + seats + "','" + status + "',CURRENT_TIMESTAMP(0),(SELECT priceperseat FROM flight WHERE flightid="+flightid+")*"+seats+");";
                String SQLStatement = "INSERT INTO FlightBooking VALUES ("+bookingid+","+customerid+","+flightid+"," +seats+",'"+status+"',CURRENT_TIMESTAMP(0),"+seats+"*(SELECT get_Fprice("+flightid+")));";
                System.out.println("SQL Statement is: " + SQLStatement);

                // execute the insert
                int rowcount = stmt.executeUpdate(SQLStatement, Statement.RETURN_GENERATED_KEYS);

                // should insert one row
                int jr = 0;
                if (rowcount == 1) {
                    System.out.println("insert done OK - Booking successful\n\n");
                    System.out.println("CONFIRMATION");
                    ResultSet justInserted = stmt.getGeneratedKeys();
                    while (justInserted.next()) {
                        jr = justInserted.getInt(1);
                    }
                    System.out.println("Booking ID:" + jr);
                    System.out.println("\nTotal cost of booking: £" + seats * pps);
                } else {
                    System.out.println("insert failed!");
                    System.out.println("CustomerID/FlightID may not exist!");
                }
                cont();
            }
            else
            {
                System.out.println("\n\nThere are "+seatsLeftOnFlight
                + " seats left on this flight, unable to book.");
                System.out.println("This flight may not exist.");
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

    public static void eight()//works
    {
        Scanner scan = new Scanner(System.in);
        int bookingid;
        System.out.println("ENTER BOOKING ID:");
        bookingid = scan.nextInt();


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
            String SQLStatement = "UPDATE FlightBooking SET Status='C' WHERE BookingID="+bookingid+";";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute the insert
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 1) {
                System.out.println("update done OK");
            } else {
                System.out.println("update failed!");
            }
            cont();
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

    public static void nine() //works //add status as h
    {

        Scanner scan = new Scanner(System.in);
        int flightid;
        System.out.println("ENTER FLIGHT ID:");
        flightid = scan.nextInt();

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
            String SQLStatement = "SELECT DISTINCT LeadCustomer.CustomerID,"
            + " LeadCustomer.FirstName, LeadCustomer.Surname, "
            + "LeadCustomer.email FROM LeadCustomer\n" +
            "INNER JOIN FlightBooking\n" +
            "ON LeadCustomer.CustomerID = FlightBooking.CustomerID\n" +
            "WHERE FlightBooking.FlightID="+flightid+" AND (FlightBooking.Status='R' OR FlightBooking.Status='H');";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            System.out.println("\n Please Contact: ");
            while (rs.next()) {
                int customerid = rs.getInt("customerid");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                System.out.println("Customer ID:" + customerid +
                        " Name:" + firstname + " " + surname
                        + " Email:" + email);
            }
            cont();
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

    public static void ten() //works
    {
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
            String SQLStatement = "UPDATE flightbooking \n" +
            "SET status='E'\n" +
            "WHERE Status='H' AND ABS(EXTRACT(EPOCH FROM current_timestamp"
            + " - FlightBooking.bookingtime)/3600) >24;";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            int rowcount = stmt.executeUpdate(SQLStatement);

            // should insert one row
            if (rowcount == 0) {
                System.out.println("Nothing to Update.");
            } else {
                System.out.println("Update done OK");
            }
            cont();
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

    public static void eleven() //works
    {
        Scanner scan = new Scanner(System.in);
        String dateOfFlight;
        System.out.println("ENTER DATE: (yyyy-mm-dd)");
        dateOfFlight = scan.nextLine();
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
            String SQLStatement = "SELECT DISTINCT Flight.FlightID,FlightDate,Origin,Destination,MaxCapacity,\n" +
            "COALESCE(MaxCapacity-(SELECT SUM(NumSeats) FROM FlightBooking \n" +
            "WHERE Flight.FlightID = Flightbooking.FlightID AND (Status = 'R' OR Status = 'H')),MaxCapacity) AS SeatsRemaining \n" +
            "FROM Flight LEFT JOIN FlightBooking ON Flight.FlightID = FlightBooking.FlightID \n" +
            "WHERE flightdate='"+dateOfFlight+"'\n" +
            "ORDER BY FlightID;";
            System.out.println("SQL Statement is: " + SQLStatement);

            // execute SQL statement
            rs = stmt.executeQuery(SQLStatement);

            // loop to step through each row of result set
            System.out.println("\nAVAILABLE FLIGHTS ON "+dateOfFlight);
            while (rs.next()) {
                int flightid = rs.getInt("flightid");
                String flightdate = rs.getString("flightdate");
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                int maxcap = rs.getInt("maxcapacity");
                int seatsremaining = rs.getInt("seatsremaining");

                System.out.println("Flight ID:" + flightid + " Flight Date:"
                        + flightdate + " Origin:" + origin + " Destination:"
                        + destination + " Max Capacity:" + maxcap
                        + " Seats Remaining:" + seatsremaining);
            }
            cont();

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

    public static void changeSeats() throws ClassNotFoundException, SQLException, DataSourceException //works
    {
        Scanner scan = new Scanner(System.in);
        int flightid, bookingid, newSeats;
        System.out.println("ENTER FLIGHT ID:");
        flightid = scan.nextInt();
        System.out.println("ENTER BOOKING ID:");
        bookingid = scan.nextInt();
        System.out.println("ENTER SEATS TO REBOOK:");
        newSeats = scan.nextInt();

        int seatsleft = getSeatsLeft(flightid);
        if (seatsleft >= newSeats) {

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
                String SQLStatement = "UPDATE FlightBooking SET numseats=" + newSeats + " WHERE BookingID=" + bookingid + ";";
                System.out.println("SQL Statement is: " + SQLStatement);

                // execute the insert
                int rowcount = stmt.executeUpdate(SQLStatement);

                // should insert one row
                if (rowcount == 1) {
                    System.out.println("update done OK");
                } else {
                    System.out.println("update failed!");
                }
                cont();

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
        } else {
            System.out.println("There are only " + seatsleft + " left, cannot rebook.");
        }
    }

    public static int getSeatsLeft(int flightID) throws ClassNotFoundException, DataSourceException, SQLException //works
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName(DataSource.getClassName());

        // connect to database from a given URL with a given username and password
        con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

        // create an SQL statement object
        stmt = con.createStatement();

        String checkSpaces = "SELECT get_SeatsLeft("+flightID+") AS seatsremaining;;";

        rs = stmt.executeQuery(checkSpaces);

        int seatsLeft = 0;
        while(rs.next())
        {
            seatsLeft = rs.getInt("seatsremaining");
        }
        return seatsLeft;
    }

    public static void exiter(String scan) //works
    {
        if(scan.equals("exit"))
        {
            System.exit(0);
        }
    }

    public static void exiter(int scan) //works
    {
        if(scan == 0)
        {
            System.exit(0);
        }
    }

    public static void cont() //works
    {
        System.out.println("Continue? (y/n)");

        Scanner scan = new Scanner(System.in);
        String scn = scan.next();
        if(scn.matches("n") || scn.matches("exit"))
        {
            System.exit(0);
        }
    }

    public static void hasNowPaid() //works
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER BOOKING ID:");
        int bookingid = scan.nextInt();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(DataSource.getClassName());

            // connect to database from a given URL with a given username and password
            con = DriverManager.getConnection(DataSource.getURL(), DataSource.getUserName(), DataSource.getPassword());

            // create an SQL statement object
            stmt = con.createStatement();

            String checkSpaces = "UPDATE flightbooking SET Status='R', BookingTime=CURRENT_TIMESTAMP(0) WHERE bookingid=" + bookingid + ";";
            System.out.println(checkSpaces);
            int row = stmt.executeUpdate(checkSpaces);
            // should insert one row
            if (row == 1) {
                System.out.println("update done OK");
            } else {
                System.out.println("update failed!");
            }
            cont();
            con.close();
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
        }
    }
}
