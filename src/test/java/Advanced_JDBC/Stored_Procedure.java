package Advanced_JDBC;

import java.sql.*;


public class Stored_Procedure {



    public static void main(String args[]) throws Exception{


        //Create_Simple_Stored_Procedure();
        Create_Simple_Stored_Procedure_With_2_Param();



    }

    // This method will Create a Stored Procedure ...

    public static void Create_Simple_Stored_Procedure() throws  SQLException{

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Laptop,123");

            Statement stmt = conn.createStatement();

            // Use The Database First ..

            stmt.execute("use SimpliLearn");


            String myQuery = "Create Procedure JDBC_Simple_CP_100()" +
                    "                    Begin" +
                    "                    Select * from BankEmp;" +
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
