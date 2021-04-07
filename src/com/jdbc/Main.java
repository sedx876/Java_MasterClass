package com.jdbc;

import java.sql.*;

public class Main {
  public static void main(String[] args){
    try{
      Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\swatk\\Downloads\\TestDB\\testdb.db");
      //conn.setAutoCommit(false);
      Statement statement = conn.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                        " (name TEXT, phone INTEGER, email TEXT)");
//      statement.execute("INSERT INTO contacts (name, phone, email) " +
//                        "VALUES('Mike', 5706373043, 'mike@me.com')");
//      statement.execute("INSERT INTO contacts (name, phone, email) " +
//                        "VALUES('Andy', 5706371234, 'andy@me.com')");
//      statement.execute("INSERT INTO contacts (name, phone, email) " +
//                        "VALUES('Sam', 5706374321, 'sam@me.com')");
      //statement.execute("UPDATE contacts SET phone=5704851234 WHERE name='Sam'");
      //statement.execute("DELETE FROM contacts WHERE name='Andy'");
//      statement.execute("SELECT * FROM contacts");
//      ResultSet results = statement.getResultSet();
      ResultSet results = statement.executeQuery("SELECT * FROM contacts");
      while(results.next()){
        System.out.println(results.getString("name") + " " +
                          results.getInt("phone") + " " +
                          results.getString("email"));
      }
      results.close();
      statement.close();
      conn.close();
    }catch(SQLException e){
      System.out.println("Something went wrong: " + e.getMessage());
    }
  }
}
