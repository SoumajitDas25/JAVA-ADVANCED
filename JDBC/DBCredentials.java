package JDBC;

public class DBCredentials
{
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_practice"; // JDBC connection URL to my db
    private static final String username = "soumajit";
    private static final String password = "200325";

    public static String getUrl()
    {
        return url;
    }
    public static String getUsername() {
        return username;
    }
    public static String getPassword()
    {
        return password;
    }
}
