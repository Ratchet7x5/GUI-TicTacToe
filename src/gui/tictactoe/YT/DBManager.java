/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rey PC
 */
public final class DBManager 
{
        //The Username and Password
        private static final String USER_NAME = "rey";
        private static final String PASSWORD = "rey";
        
        //DB host
        private static final String URL = "jdbc:derby://localhost:1527/TTToeDB;create=true";
        
        Connection connection;
        
        public DBManager()
        {
            establishConnection();
        }
        
        public Connection getConnection()
        {
            return this.connection;
        }
        
        public void establishConnection()
        {
            if(this.connection == null)
            {
                try{
                    connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                    System.out.println(URL+" Connected..");
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        //Stop the connection
        public void closeConnections() 
        {
        if (connection != null) 
        {
            try {
                connection.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}