package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Stored_procedure {



    public static void main(String args[]) throws Exception {

        JDBC_Stored_procedure obj = new JDBC_Stored_procedure();

        obj.Create_Stored_Procedure();

    }



    public void Create_Stored_Procedure(){


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306","root","Laptop,123");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            // Select/Use The Data Base

            stmt.execute("use SimpliLearn;");

            stmt.execute("CREATE PROCEDURE `retrieveData`()" +
                    "BEGIN" +
                    "select FName , LName , Email" +
                    "from BankEmp" +
                    "where state = 'wb';" +
                    "END;"

            );







            System.out.println("Stored Procedure Creation.. is Successfull ....");

            con.close();
        }catch(Exception e){ e.printStackTrace();}

    }








}
