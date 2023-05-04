package dataBase;


import java.sql.*;

public class JDBC_CreateDB {

    public static void main(String[] args) {

        // auto close connection
        try{ Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306", "root", "Laptop,123");

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            Statement Stmt = conn.createStatement();

            Stmt.execute("CREATE DATABASE hello_db");
            Stmt.execute("CREATE TABLE hello_table (f00 char(31))");
            conn.commit(); // now the database physically exists
            Stmt.execute("OPEN DATABASE hello_db");
            Stmt.executeUpdate ("INSERT INTO hello_table VALUES (”Hello World”)");
            conn.commit(); //Commits all changes



        } catch (SQLException e) {
            System.err.format("SQL State: %s%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}