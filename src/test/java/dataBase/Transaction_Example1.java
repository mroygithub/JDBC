package dataBase;

import java.sql.*;


public class Transaction_Example1 {

    public static Connection con;


    public static void Trans_Example() {




        try {


            // db credentials
            String jdbcEndpoint
                    = "jdbc:mysql://localhost:3306";
            String userid = "root";
            String password = "Laptop,123";

            // create a connection to db
            Connection connection = DriverManager.getConnection(
                    jdbcEndpoint, userid, password);

            // construct a query
            Statement deleteStmt = connection.createStatement();
            String deleteQuery
                    = "DELETE FROM BankEmp WHERE EmpId = 100";

            deleteStmt.execute("use SimpliLearn;");

            // Disable auto commit to connection
            connection.setAutoCommit(true);

            // deleteQuery
            Savepoint beforeDeleteSavepoint
                    = connection.setSavepoint();

            // Executing the deleteQuery
         int count = deleteStmt.executeUpdate(deleteQuery);


            System.out.println("Number of rows updated by executing query1 =  " + count);


            System.out.println("##########################");

            // Rollback to our beforeDeleteSavepoint
            connection.rollback(beforeDeleteSavepoint);
            connection.commit();



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
