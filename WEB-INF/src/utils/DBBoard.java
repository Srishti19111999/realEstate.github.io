package utils;

import java.sql.*;

public class DBBoard{
    public static String dbURL;

    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(dbURL);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}