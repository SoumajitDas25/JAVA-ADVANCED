package JDBC;

import java.sql.*;
import java.util.Scanner;

public class TransactionHandling
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
        try(Connection connection = DriverManager.getConnection(DBCredentials.getUrl(),DBCredentials.getUsername(),DBCredentials.getPassword()))
        {
            connection.setAutoCommit(false); //sets the auto-commit mode of connection to false which means we have to manually commit after we have successfully finished with executing queries or rollback if there is some error or inconsistency while executing queries.

            Scanner in = new Scanner(System.in);

            //write debit & credit queries
            String deditQuery = "UPDATE Account SET balance = balance - ? WHERE Account_no = ?";
            String creditQuery = "UPDATE Account SET balance = balance + ? WHERE Account_no = ?";

            //create prepareStatement for debit & credit
            PreparedStatement debitPreparedStatement = connection.prepareStatement(deditQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);

            //input the sender account_no, receiver_account_no & amount to be transferred
            System.out.println("Enter your Account No.");
            int sender_account_no = in.nextInt();
            System.out.println("Enter the receiver Account_no");
            int receiver_account_no = in.nextInt();
            System.out.println("Enter Amount to be transferred");
            int amount = in.nextInt();
            debitPreparedStatement.setInt(1,amount);
            debitPreparedStatement.setInt(2,sender_account_no);
            creditPreparedStatement.setInt(1,amount);
            creditPreparedStatement.setInt(2,receiver_account_no);

            //execute debit & credit
            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();

            //check whether sender has sufficient balance for debit
            if(isBalanceSufficientForDebit(connection,amount,sender_account_no))
            {
                connection.commit(); //commit if its sufficient
                System.out.println("Transaction Successful !");
            }
            else
            {
                connection.rollback(); //rollback if its not sufficient
                System.out.println("Transaction Failed !");
            }
            in.close();
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }

    static boolean isBalanceSufficientForDebit(Connection connection,int amount,int sender_account_no)
    {
        try
        {
            //fetch sender's current balance
            String query = "SELECT balance FROM Account WHERE Account_no = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,sender_account_no);
            ResultSet result = statement.executeQuery();
            if(result.next())
            {
                //check sender balance >= balance
                int current_balance = result.getInt("balance");
                if(amount>current_balance)
                    return false;
                else
                    return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
