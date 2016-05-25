package com.gm;

import java.io.IOException;
import java.sql.*;

public class Main {




    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
	// write your code here

        //Connection conn = null;
        //Statement stmt = null;
        //System.out.println("Hello ubuntu!");

        //ReadEmployee();

        SolidReader solidReader = new SolidReader();
        solidReader.ReadHtml();
    }

    private static void ReadEmployee() throws ClassNotFoundException, SQLException {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://10.10.10.101/printlog";

        //Database credentials
        final String USER = "root";
        final String PASSWORD = "123@abc";

        Class.forName(JDBC_DRIVER);

        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD)) {

            try (Statement stmt = conn.createStatement()) {

                String sql = "SELECT name, department  FROM person limit 10";
                ResultSet rs = stmt.executeQuery(sql);
                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name

                    String name = rs.getString("name");
                    String department = rs.getString("department");

                    //Display values

                    System.out.print("Person: " + name);
                    System.out.println(" Department: " + department);
                }
                rs.close();
                //stmt.close();
            }
            //conn.close();
        }
    }
}
