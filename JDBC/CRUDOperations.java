package JDBC;

import java.sql.*;

public class CRUDOperations
{
    public static void main(String[] args)
    {
        //Load the Driver
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found!");
        }

        //Create Connection
        try(Connection connection = DriverManager.getConnection(DBCredentials.getUrl(),DBCredentials.getUsername(),DBCredentials.getPassword())) //here, we have used try-with-resources block to ensure if anything goes wrong, the connections will be properly closed which is a good practice
        {
            //CRUD Operations using Statement Interface:

            //1. Retrieving data(we use executeQuery())
            Statement statement = connection.createStatement();
            String query1 = "SELECT * FROM Student";
            ResultSet result1 = statement.executeQuery(query1); //returns a resultSet implementation class object containing the retrieved data
            while(result1.next())
            {
                System.out.println(result1.getInt("id")+" "+result1.getString("name")+" "+result1.getString("course")+" "+result1.getString("semester"));
            }

            //2. Inserting data(we use executeUpdate())
            //String query2 = String.format("INSERT INTO Student(id,name,course,semester) VALUES(%o,'%s','%s',%o)",5,"Deb","Btech",3);
            //int result2 = statement.executeUpdate(query2); //returns the no of rows inserted
            //if(result2>0)
                //System.out.println(result2+" Rows Inserted");
            //else
                //System.out.println("Data not Inserted");

            //3. Updating data(we use executeUpdate())
            //String query3 = "UPDATE Student SET semester = 5 WHERE id = 4";
            //int result3 = statement.executeUpdate(query3); //returns the no of rows updated
            //if(result3>0)
                //System.out.println(result3+" Rows Updated");
            //else
                //System.out.println("No Rows Updated");

            //4. Deleting data(we use executeUpdate())
            //String query4 = "DELETE FROM Student WHERE id = 5";
            //int result4 = statement.executeUpdate(query4); //returns the no of rows deleted
            //if(result4>0)
                //System.out.println(result4+" Rows Deleted");
            //else
                //System.out.println("No Rows Deleted");

            //CRUD Operations using PreparedStatement Interface:

            //1. Inserting Data
            //String query5 = "INSERT INTO Student(id,name,course,semester) VALUES(?,?,?,?)"; //? are placeholders which parameterize the values
            //PreparedStatement preparedStatement1 = connection.prepareStatement(query5);
            //add values for the placeholders
            //preparedStatement1.setInt(1,10);
            //preparedStatement1.setString(2,"Blaze");
            //preparedStatement1.setString(3,"BBA");
            //preparedStatement1.setInt(4,6);
            //int result5 = preparedStatement1.executeUpdate(); //returns the no. of rows inserted
            //if(result5 > 0)
                //System.out.println(result5+" Rows Inserted!");
            //else
                //System.out.println("No Rows Inserted!");

            //2. Retrieving Data
            String query6 = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query6);
            preparedStatement2.setInt(1,3);
            ResultSet result6 = preparedStatement2.executeQuery(); //returns resultSet implementation class object containing the retrieved data
            while (result6.next())
            {
                System.out.println(result6.getInt("id")+" "+result6.getString("name")+" "+result6.getString("course")+" "+result6.getString("semester"));
            }

            //3. Updating Data
            //String query7 = "UPDATE Student SET name = ? WHERE ID = ?";
            //PreparedStatement preparedStatement3 = connection.prepareStatement(query7);
            //preparedStatement3.setString(1,"Raven");
            //preparedStatement3.setInt(2,10);
            //int result7 = preparedStatement3.executeUpdate(); //returns the no. of rows updated
            //if(result7 > 0)
                //System.out.println(result7+" Rows Updated!");
            //else
                //System.out.println("No Rows Updated!");

            //4. Deleting Data
            //String query8 = "DELETE FROM Student WHERE ID = ?";
            //PreparedStatement preparedStatement4 = connection.prepareStatement(query8);
            //preparedStatement4.setInt(1,10);
            //int result8 = preparedStatement4.executeUpdate(); //returns the no. of rows deleted
            //if(result8 > 0)
                //System.out.println(result8+" Rows Deleted!");
            //else
                //System.out.println("No Rows Deleted!");

        }

        catch (SQLException e)
        {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
}