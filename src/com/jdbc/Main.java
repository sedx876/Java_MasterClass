package com.jdbc;

import java.sql.*;

public class Main {

  public static final String DB_NAME = "testdb.db";
  public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\swatk\\Downloads\\TestDB\\"+ DB_NAME;
  public static final String TABLE_CONTACTS = "contacts";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_PHONE = "phone";
  public static final String COLUMN_EMAIL = "email";

  public static void main(String[] args){
    try{
      Connection conn = DriverManager.getConnection(CONNECTION_STRING);
      //conn.setAutoCommit(false);
      Statement statement = conn.createStatement();
      statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
      statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                        " (" + COLUMN_NAME + " text, " +
                               COLUMN_PHONE + " integer, " +
                               COLUMN_EMAIL + " text" +
                        ")");
//      statement.execute("INSERT INTO" + TABLE_CONTACTS +
//                              " (" + COLUMN_NAME + ", " +
//                                     COLUMN_PHONE + ", " +
//                                     COLUMN_EMAIL +
//                              " ) " +
//                              "VALUES('Sharon', 5706378765, 'sharon@me.com')");
//
//      statement.execute("INSERT INTO" + TABLE_CONTACTS +
//                              " (" + COLUMN_NAME + ", " +
//                                     COLUMN_PHONE + ", " +
//                                     COLUMN_EMAIL +
//                              " ) " +
//                              "VALUES('Andy', 5706373043, 'andy@me.com')");
//
//      statement.execute("INSERT INTO" + TABLE_CONTACTS +
//                              " (" + COLUMN_NAME + ", " +
//                                     COLUMN_PHONE + ", " +
//                                     COLUMN_EMAIL +
//                              " ) " +
//                              "VALUES('Sam', 5706371234, 'sam@me.com')");
      insertContact(statement,"Sharon", 6378765, "sharon@email.com");
      insertContact(statement,"Mike", 6373043, "mike@anywhere.com");
      insertContact(statement,"Andy", 6371234, "andy@somewhere.com");
      insertContact(statement,"Sam", 6374321, "sam@email.com");
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
      ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
//      while(results.next()){
//        System.out.println(results.getString("name") + " " +
//                          results.getInt("phone") + " " +
//                          results.getString("email"));
//      }
      while(results.next()) {
        System.out.println(results.getString(COLUMN_NAME) + " " +
            results.getInt(COLUMN_PHONE) + " " +
            results.getString(COLUMN_EMAIL));
      }
      results.close();
      statement.close();
      conn.close();
    }catch(SQLException e){
      System.out.println("Something went wrong: " + e.getMessage());
    }
  }

  private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
    statement.execute("INSERT INTO " + TABLE_CONTACTS +
        " (" + COLUMN_NAME + ", " +
               COLUMN_PHONE + ", " +
               COLUMN_EMAIL +
        " ) " +
        "VALUES('" + name + "', " + phone + ", '" + email + "')");
  }
}
