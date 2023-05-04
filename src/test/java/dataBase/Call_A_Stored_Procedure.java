package dataBase;

import java.sql.*;


public class Call_A_Stored_Procedure {


    public static void getSkills(String  state1 , String state2) {
        //
        String query = "{ call pr_EmpDetalsAsPerSate_Mul(?,?) }";
        ResultSet rs;



        try {//Registering the Driver
             Connection con= DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306","root","Laptop,123");
             CallableStatement stmt = con.prepareCall(query);

            stmt.execute("use SimpliLearn;");


            stmt.setString(1, state1);
            stmt.setString(2, state2);




            rs = stmt.executeQuery();
            while (rs.next()) {

                String FName  = rs.getString("FName");
                String LName  = rs.getString("LName");
                Double Mo  = rs.getDouble("Mobile");
                System.out.println(FName+":"+LName+":"+String.valueOf(Mo));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        getSkills("WB" , "KR");
    }
}
