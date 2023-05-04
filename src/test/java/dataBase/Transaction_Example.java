package dataBase;

import java.sql.*;


public class Transaction_Example {

    public static Connection con;


    public static void Trans_Example() {


        // Select Query to get the data from BankEmp


        String query = "select FName , LName , Mobile from BankEmp where state = 'KR';";
        String query1 = "select FName , LName , Mobile from BankEmp where state = 'WB';";

        ResultSet rs = null;
        Boolean autocommit;

        String update_Query = "UPDATE BankEmp set Doj = '2000-07-01' where EmpId = 1";
        String update_Query1 = "UPDATE BankEmp set Doj = '2000-09-01' where EmpId = 2";

        try {


            //Registering the Driver
            con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306","root","Laptop,123");
             CallableStatement stmt = con.prepareCall(query);


            // Settin the Autocommit status as False

            System.out.println("Settin the Autocommit status as False");

            con.setAutoCommit(true);
            autocommit = con.getAutoCommit();
            System.out.println("AutoCommit value of the connection = "+ autocommit);



            stmt.execute("use SimpliLearn;");

            // checking whether select query is getting executed or not?


            stmt.executeUpdate(update_Query);


            rs = stmt.executeQuery("select * from BankEmp1");

            displayTableResult(rs);




        } catch (SQLException ex) {

            try {

                if (con != null) {

                    con.rollback();
                }
            }
            catch(SQLException e){}


            System.out.println(ex.getMessage()

            );
        }
    }


    public static void displayTableResult(ResultSet rs1) throws SQLException{


        while (rs1.next()) {

            String FName = rs1.getString("FName");
            String LName = rs1.getString("LName");
            Date DT = rs1.getDate("Doj");
            System.out.println(FName + ":" + LName + ":" + String.valueOf(DT));
        }
    }



    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Trans_Example();
    }
}
