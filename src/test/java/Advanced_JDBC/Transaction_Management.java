package Advanced_JDBC;

import java.sql.*;
import java.util.Queue;


public class Transaction_Management {



    public static void main(String args[]) throws Exception{


        //Create_Simple_Stored_Procedure();
        UseOfSetAutoCommit();



    }

    // This method will Create a Stored Procedure ...

    public static void UseOfSetAutoCommit() throws  SQLException{

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Laptop,123");

            Statement stmt = conn.createStatement();

            String query = "update BankEmp set Doj = '2000-04-04' where EmpId = 1;";

            conn.setAutoCommit(false);

            // This is Transaction 1 .....

            stmt.execute("use SimpliLearn;");
            int result = stmt.executeUpdate(query);

            System.out.println("Transaction 1 ==>Numbers of row updated because of this Query ===="+result);



            // This is Transaction 2 .....

            String query1 = "update BankEmp set Doj = '2000-03-03' where EmpId = 2;";

            stmt.execute("use SimpliLearn;");
            // This is Transaction 1 .....

            stmt.execute("use SimpliLearn;");
            int result1 = stmt.executeUpdate(query1);

            System.out.println("Transaction 2 ==>Numbers of row updated because of this Query ===="+result1);
            conn.commit();

        }

        catch (Exception e){
            System.out.println(e.getMessage());
        };

    }


    // This method will Create a Stored Procedure ...

    public static void Create_Simple_Stored_Procedure_With_2_Param() throws  SQLException{

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Laptop,123");

            Statement stmt = conn.createStatement();

            // Use The Database First ..

            stmt.execute("use SimpliLearn");


            String myQuery = "Create Procedure Get_EMP_ST_VK(ST varchar(2) , VK varchar(20) )" +
                    "                    Begin" +
                    "                    select EmpId , Mobile , Vehicle , Fname, LName , Vehicle , State from BankEmp where Vehicle = VK and State = ST;" +
                    "                    End"
                    ;

            // Execute the Query ..

            stmt.execute(myQuery);

            System.out.println("The Stored Procedure With Name JDBC_Simple_CP Created Successfully ....");

        }

        catch (Exception e){
            System.out.println(e.getMessage());
        };

    }








}
