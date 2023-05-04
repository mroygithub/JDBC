package dataBase;

import java.sql.*;

public class Stored_Procedure_1 {
    public static void main(String args[]) throws SQLException {

        call_A_Stored_Procedure(16,"6655456787","Mac" , "Book" , "Mac@Book.com" , "UP" , "1999-09-08" , "Car");

    }


    public static void create_A_Stored_Procedure_To_Insert_Data() throws SQLException{
        //Registering the Driver
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306","root","Laptop,123");
        //here sonoo is database name, root is username and password
        Statement stmt=con.createStatement();

        // Select/Use The Data Base

        stmt.execute("use SimpliLearn;");
        //Query to create stored procedures
        String query = "CREATE  PROCEDURE `InsertDataIntoBankEmp_New`(id int,mobile Double,fname varchar(50) , lname varchar(50), email varchar(50), st varchar(2) , doj Date , vc varchar(50)) " +
                "BEGIN "+
                "Insert into BankEmp(EmpId,Mobile,FName,LName,Email,State,Doj,Vehicle) values (id,mobile,fname,lname,email,st,doj,vc);"+
                "END";
        //Executing the query
        stmt.execute(query);
        System.out.println("Stored Procedure Created......");
    }


    public static void call_A_Stored_Procedure(int id , String Mo , String FN , String LN , String Em , String ST , String DOJ , String VC) throws SQLException{


        //Registering the Driver
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306","root","Laptop,123");
        //here sonoo is database name, root is username and password

        String query = "{ call InsertDataIntoBankEmp_New(?,?,?,?,?,?,?,?) }";
        CallableStatement stmt = con.prepareCall(query);

        stmt.execute("use SimpliLearn;");


        stmt.setInt(1, id);
        stmt.setDouble(2, Double.valueOf(Mo));
        stmt.setString(3, FN);
        stmt.setString(4, LN);
        stmt.setString(5, Em);
        stmt.setString(6, ST);
        stmt.setString(7, DOJ);
        stmt.setString(8, VC);

        ResultSet rs = stmt.executeQuery();

    }
}