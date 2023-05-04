package Advanced_JDBC;

import java.sql.*;


public class Call_A_Stored_Procedure {



    public static void main(String args[]) throws Exception{


        //Create_Simple_Stored_Procedure();
       // Call_Simple_Stored_Procedure_With_2_Param("BL" , "Car");

        Call_Simple_Stored_Procedure();



    }




    // This method will Call a Stored Procedure with 2 Params ...

    public static void Call_Simple_Stored_Procedure_With_2_Param(String state , String vehicle) throws  SQLException{

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Laptop,123");



            String Query = "{call Get_EMP_ST_VK(?,?)}";

            CallableStatement STMT = conn.prepareCall(Query);
            STMT.execute("use SimpliLearn;");

            STMT.setString(1 , state);
            STMT.setString(2 , vehicle);

            ResultSet result = STMT.executeQuery();

            while(result.next())
            {
                int ID = result.getInt("EmpId");
                String FName = result.getString("FName");
                String LName = result.getString("LName");
                String State = result.getString("State");
                String Vehicle = result.getString("Vehicle");
                System.out.println(ID+":"+FName+":"+LName+":"+State+":"+Vehicle);
            }

                System.out.println("The Stored call is Successfully ....");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        };
    }


    // This method will Call a Stored Procedure with 2 Params ...

    public static void Call_Simple_Stored_Procedure() throws  SQLException{

        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Laptop,123");



            String Query = "{call JDBC_Simple_CP()}";

            CallableStatement STMT = conn.prepareCall(Query);
            STMT.execute("use SimpliLearn;");

           // STMT.setString(1 , state);
           // STMT.setString(2 , vehicle);

            ResultSet result = STMT.executeQuery();

            while(result.next())
            {
                int ID = result.getInt("EmpId");
                String FName = result.getString("FName");
                String LName = result.getString("LName");
                String State = result.getString("State");
                String Vehicle = result.getString("Vehicle");
                System.out.println(ID+":"+FName+":"+LName+":"+State+":"+Vehicle);
            }

            System.out.println("The Stored call is Successfully ....");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        };
    }



}
