package JDBC;

import java.sql.*;

//JDBC(Java Database connectivity) is a Java API for connecting & interacting with databases.
//JDBC requires its drivers(which is different for different RDBMS) which are software components which provide the necessary functionality to connect java applications to different databases.
//There are 4 types of JDBC drivers:
//1. JDBC-ODBC bridge Driver
//2. Native-API Partly Java Driver
//3. Network Protocol Pure Java Driver
//4. Thin Driver(also known as Direct to Database Pure Java Driver) (recommended & used today)

//Flow of JDBC Program:
//1. Connect the IDE with the database using JDBC driver(Connector JAR file)
//2. Load the JDBC driver
//3. Create Connection
//4. Create Statement
//5. Execute SQL query
//6. Process Result(if any)
//7. Close Everything

//Key JDBC Classes/Interfaces:
//1. DriverManager(Class): Manages DB drivers & creates connection
//2. Connection(Interface): Represents the connection to the DB
//3. Statement(Interface): Used to send SQL queries
//4. PreparedStatement(Interface): Used for parameterized queries(more secure)
//5. ResultSet(Interface): Stores data returned by SELECT queries

public class JDBCBasics
{
    public static void main(String[] args)
    {
        String url = DBCredentials.getUrl(); // JDBC connection URL to my db
        String username = DBCredentials.getUsername();
        String password = DBCredentials.getPassword();

        //Load the JDBC driver
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); //we are passing the path to the Driver class
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found!");
        }

        try
        {
            //Create Connection
            Connection connection = DriverManager.getConnection(url,username,password); //this method will return an object of an implementation class of Connection interface which is defined in the driver files(different RDBMS drivers will have their own implementation class of this interface whose object will be returned by this method)

            //Create Statement
            Statement statement = connection.createStatement();
            String query1 = "SELECT * FROM Student"; //SQL Query

            //Execute SQL Query
            ResultSet result = statement.executeQuery(query1); //it will return an object of ResultSet Implementation class on which we will perform our operations
            //executeQuery() is used when we want to retrieve data & executeUpdate() is used when we want to insert,update,delete data

            //Process Result
            while (result.next()) //next() will move the ResultSet cursor/pointer forward by one row from its current position & will return true if the current row exist else false if no row exist(Initially, the pointer is positioned before the first row)
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                String course = result.getString("course");
                int semester = result.getInt("semester");
                System.out.println(id+" "+name+" "+course+" "+semester);
            }

        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
}
