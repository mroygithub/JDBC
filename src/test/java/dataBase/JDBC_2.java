package dataBase;


import java.sql.*;

public class JDBC_2 {

    public static void main(String[] args) {

        // auto close connection
        try{ Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/TESTMIT", "root", "Laptop,123");

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select password from users");
            while(rs.next())
                System.out.println(rs.getString(1));
            conn.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}