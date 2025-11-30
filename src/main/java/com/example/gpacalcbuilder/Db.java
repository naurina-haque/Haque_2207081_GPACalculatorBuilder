package com.example.gpacalcbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Db {
    public Connection connection;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public void getconnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Dell/OneDrive/Desktop/intellij java/GPACalcBuilder/database.db");
                logger.info("Database connection established");
                createtable();
            }

        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Connection closed");
            }
        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }

    public void createtable()
    {
        String query="Create table if not exists coursedata (id integer not null primary key autoincrement,Course_name text not null,Course_code text not null,Credit text not null,Teacher_1 text not null,Teacher_2 text not null,Grade text not null )";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.executeUpdate();
            logger.info("Table created");
        }
        catch(SQLException e)
        {
            logger.info(e.toString());
        }
    }
    public void insertdata(String Course_name,String Course_code,String Credit,String Teacher_1,String Teacher_2,String Grade) throws SQLException {

        String query = "Insert into coursedata (Course_name,Course_code,Credit,Teacher_1,Teacher_2,Grade) values (?,?,?,?,?,?)";
        try(PreparedStatement statement= connection.prepareStatement(query))
        {
            statement.setString(1, Course_name);
            statement.setString(2, Course_code);
            statement.setString(3, Credit);
            statement.setString(4, Teacher_1);
            statement.setString(5, Teacher_2);
            statement.setString(6, Grade);
            statement.executeUpdate();
            logger.info("Course inserted");

        } catch (SQLException e) {
            logger.info(e.toString());
        }


    }
}