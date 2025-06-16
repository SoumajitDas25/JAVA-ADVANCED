package JDBC;

import java.sql.*;
import java.util.ArrayList;

//Bach Processing is executing multiple SQL queries at one time instead of executing them one by one.
//It can be done through Statement & PreparedStatement Interface but PreparedStatement is more recommended to use.

public class BatchProcessing
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
            //Batch Processing using Statement Interface:
            //ArrayList<Student> list = new ArrayList<>();
            //list.add(new Student(20,"Rebecca","BE",5));
            //list.add(new Student(21,"Blaze","BA",2));
            //list.add(new Student(22,"Velvet","LLB",1));
            //list.add(new Student(23,"Rosemerry","BCOM",7));
            //list.add(new Student(24,"Sarah","BE",6));
            //Statement statement = connection.createStatement();
            //for(Student student: list)
            //{
                //String query = String.format("INSERT INTO Student(id,name,course,semester) VALUES(%o,'%s','%s',%o)",student.getId(),student.getName(),student.getCourse(),student.getSemester());
                //statement.addBatch(query); //add the query to the batch/list of queries
            //}
            //int[] result = statement.executeBatch();//submits the batch of queries to the database for execution & returns an int array containing either 1 or 0 corresponding to the success or failure of each query in the batch.

            //Batch Processing using PreparedStatement Interface:
            ArrayList<Student> list2 = new ArrayList<>();
            list2.add(new Student(30,"Lily","MBA",5));
            list2.add(new Student(31,"Paul","BOPT",2));
            list2.add(new Student(32,"Kane","MTech",1));
            list2.add(new Student(33,"Charliotte","BPharma",7));
            list2.add(new Student(34,"Johnathan","BE",6));
            String query = "INSERT INTO Student(id,name,course,semester) VALUES(?,?,?,?)";
            PreparedStatement statement2 = connection.prepareStatement(query);
            for(Student student: list2)
            {
                statement2.setInt(1,student.getId());
                statement2.setString(2,student.getName());
                statement2.setString(3,student.getCourse());
                statement2.setInt(4,student.getSemester());
                statement2.addBatch(); //here, in case of preparedStatement, we don't pass the query here as it was already passed at the time of initialization
            }
            int[] result2 = statement2.executeBatch();

        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
}

class Student
{
    private int id,semester;
    private String name,course;

    Student(int id,String name,String course,int semester)
    {
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public int getSemester() {
        return semester;
    }
}