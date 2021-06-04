/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;

import java.sql.*;

/**
 * SQL Class enables to create tables and insert data into tables
 *
 * @author Rey PC
 */
public class StorePlayers {
    
        private final DBManager dbMan;
        private final Connection conn;
        private Statement statement;
        
        public StorePlayers(){
            dbMan = new DBManager();
            conn = dbMan.getConnection();
        }
        
        public void createTTToeDB(){
            try{
                this.statement = conn.createStatement();
                this.checkExistedTable("PLAYERS");
                this.statement.addBatch("CREATE TABLE PLAYERS (PLAYERID INT PRIMARY KEY, NAME VARCHAR(50), MATCHES_PLAYED INT, WINS INT, LOSES INT)");
                this.statement.executeBatch();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        //Count how amny players there are and stores the player ID
        public int countRows() throws SQLException {
             // select the number of rows in the table
            ResultSet rs = null;
            int rowCount = -1;
            try {
                this.statement = this.conn.createStatement();
                rs = this.statement.executeQuery("SELECT COUNT(*) FROM PLAYERS");
                // get the number of rows from the result set
                rs.next();
                rowCount = rs.getInt(1);
            } finally {
                rs.close();
                this.statement.close();
            }
            return rowCount;
        }
        
        //Create a new Player
        public void createNewPlayer(GamePlayer gp){
            String sql = "INSERT INTO PLAYERS VALUES (?,?,?,?,?)";
            
            try{
                this.checkExistedName(gp.getPlayerName());
                //Create a new Player ID
                int newID = countRows();
                ++newID;
                PreparedStatement s = conn.prepareStatement(sql);
                s.setInt(1, newID);
                s.setString(2, gp.getPlayerName());
                s.setInt(3, gp.getMatchesPlayed());
                s.setInt(4, gp.getWins());
                s.setInt(5, (gp.getMatchesPlayed()-gp.getWins()) );
                s.executeUpdate();
                
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            
        }
        
        //Check for exicting player name
        public void checkExistedName(String name) {
           String sql = "SELECT PlayerID, NAME FROM PLAYERS WHERE NAME = '"+name+"'";
            try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            this.statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                int oldID = rs.getInt("PLAYERID");
                String oldName = rs.getString("NAME");
                System.out.println(oldName);
                if (oldName.equalsIgnoreCase(name)) {
                    statement.executeUpdate("DELETE FROM PLAYERS WHERE PLAYERID = " + oldID);
                    System.out.println("Name " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        //Check existing table
        public void checkExistedTable(String name) {
            try {
                DatabaseMetaData dMeta = this.conn.getMetaData();
                String[] types = {"TABLE"};
                statement = this.conn.createStatement();
                ResultSet results = dMeta.getTables(null, null, null, types);

                while (results.next()) {
                    String table_name = results.getString("TABLE_NAME");
                    System.out.println(table_name);
                    if (table_name.equalsIgnoreCase(name)) {
                        statement.executeUpdate("DROP TABLE " + name);
                        System.out.println("TABLE " + name + " has been deleted.");
                        break;
                    }
                }
                results.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }   
        
        public void closeConnection() {
            this.dbMan.closeConnections();
        }
}